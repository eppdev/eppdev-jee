/*
 * FileName: SchemaService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-12
 */

package cn.eppdev.codegenerator.manager.service;

import cn.eppdev.codegenerator.builder.AppPropsBuildService;
import cn.eppdev.codegenerator.builder.ApplicationBuildService;
import cn.eppdev.codegenerator.builder.PomBuildService;
import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.manager.entity.EppdevIndex;
import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.utils.conf.TypeStdUtils;
import cn.eppdev.codegenerator.utils.conf.TypesMapperUtils;
import cn.eppdev.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author fan.hao
 */
@Service
@Transactional(readOnly = false)
public class SchemaService {

    private static Logger logger = LoggerFactory.getLogger(SchemaService.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    EppdevTableService tableService;

    @Autowired
    EppdevColumnService columnService;

    @Autowired
    EppdevIndexService indexService;

    @Autowired
    EppdevVersionService versionService;

    @Autowired
    GeneratorService generatorService;

    @Autowired
    ApplicationBuildService applicationBuildService;

    @Autowired
    AppPropsBuildService appPropsBuildService;

    @Autowired
    PomBuildService pomBuildService;

    @Autowired
    EppdevConfService confService;


    public List<EppdevTable> listTablesFromConn() {
        List<EppdevTable> eppdevTableList = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            String[] tableTypes = {"TABLE", "VIEW"};
            ResultSet rs = conn.getMetaData().getTables(null,
                    null,
                    null,
                    tableTypes);
            // 表信息
            while (rs.next()) {
                EppdevTable eppdevTable = new EppdevTable();
                eppdevTable.setTableName(rs.getString("TABLE_NAME"));
                eppdevTable.setTableComment(rs.getString("REMARKS"));
                eppdevTableList.add(eppdevTable);
            }
            rs.close();

            // 列信息
            for (EppdevTable eppdevTable : eppdevTableList) {
                rs = conn.getMetaData().getColumns(null, null, eppdevTable.getTableName(), null);
                List<EppdevColumn> columnList = new ArrayList<>();
                while (rs.next()) {
                    EppdevColumn column = new EppdevColumn();
                    column.setColumnName(rs.getString("COLUMN_NAME"));
                    column.setColumnType(rs.getString("TYPE_NAME"));
                    column.setColumnLength(rs.getInt("COLUMN_SIZE"));
                    column.setColumnComment(rs.getString("REMARKS"));
                    columnList.add(column);
                }
                eppdevTable.setColumnList(columnList);
                rs.close();
            }

            // 索引信息
            for (EppdevTable eppdevTable : eppdevTableList) {
                rs = conn.getMetaData().getIndexInfo(null, null, eppdevTable.getTableName(), false, true);

                // 读取数据
                Map<String, List<Map<String, Object>>> indexMap = new HashMap<>();
                while (rs.next()) {
                    String indexName = rs.getString("INDEX_NAME");
                    String columnName = rs.getString("COLUMN_NAME");
                    int indexPosition = rs.getInt("ORDINAL_POSITION");
                    Map<String, Object> columnInfoMap = new HashMap<>();
                    columnInfoMap.put("columnName", columnName);
                    columnInfoMap.put("indexPosition", indexPosition);
                    if (indexMap.containsKey(indexName)) {
                        List<Map<String, Object>> list = indexMap.get(indexName);
                        list.add(columnInfoMap);
                    } else {
                        List<Map<String, Object>> list = new ArrayList<>();
                        list.add(columnInfoMap);
                        indexMap.put(indexName, list);
                    }
                }
                rs.close();

                // 处理数据
                List<EppdevIndex> indexList = new ArrayList<>();
                for (String idxName : indexMap.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    List<Map<String, Object>> colList = indexMap.get(idxName);
                    colList.sort(new Comparator<Map<String, Object>>() {
                        @Override
                        public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                            return ((Integer) o1.get("indexPosition")).compareTo((Integer) o2.get("indexPosition"));
                        }
                    });
                    for (Map<String, Object> map : colList) {
                        sb.append(map.get("columnName") + ",");
                    }
                    String indexColumns = StringUtils.removeEnd(sb.toString(), ",");
                    EppdevIndex index = new EppdevIndex();
                    index.setIndexName(idxName);
                    index.setColumnNames(indexColumns);
                    indexList.add(index);
                }
                eppdevTable.setIndexList(indexList);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eppdevTableList;
    }

    @Transactional(readOnly = false)
    public void updateTableInfo() {
        List<EppdevTable> eppdevTableList = listTablesFromConn();
        logger.debug("eppdevTableList: {}", eppdevTableList);

        for (EppdevTable table : eppdevTableList) {
            // 处理表信息
            String tableId = null;
            String tableName = table.getTableName();
            EppdevTable table1Param = new EppdevTable();
            table1Param.setTableName(tableName);
            table1Param.setVersionId(EppdevTableService.DEFAULT_VERSION_ID);
            List<EppdevTable> resultList = tableService.listBy(table1Param, null, null).getList();
            if (resultList.size() > 1) {
                throw new RuntimeException("内部错误，重复表：" + tableName);
            } else if (resultList.size() == 1) {
                tableId = resultList.get(0).getId();
            } else {
                tableService.save(table);
                tableId = table.getId();
            }

            // 处理字段信息
            EppdevColumn columnParm = new EppdevColumn();
            columnParm.setTableId(tableId);
            List<EppdevColumn> columnListOrigin = columnService.listBy(columnParm, null, null).getList();
            logger.debug("columnListOrigin: {}", columnListOrigin);
            List<EppdevColumn> columnListNew = table.getColumnList();
            logger.debug("columnListNew: {}", columnListNew);
            for (EppdevColumn column : columnListNew) {
                logger.debug("column: {}", column);
                boolean exists = false;
                column.setTableId(tableId);
                String newType = TypesMapperUtils.getStdFromMysql(column.getColumnType());
                if(column.getColumnType() == null){
                    logger.error("Error when generate columnType: {}", column);
                    throw new RuntimeException("库表类型暂不支持：" + column.getColumnType());
                }
                column.setColumnType(newType);

                for (EppdevColumn originColumn : columnListOrigin) {
                    if (column.getColumnName().equals(originColumn.getColumnName())) {
                        if (!column.getColumnType().equals(originColumn.getColumnType()) // 类型不同
                                || (TypeStdUtils.needLengthConf().get(column.getColumnType())   // 长度有意义且长度不一致
                                && column.getColumnLength() != originColumn.getColumnLength())) {
                            originColumn.setColumnType(column.getColumnType());
                            if(null != column.getColumnComment() && column.getColumnComment().trim().length() > 0) {
                                originColumn.setColumnComment(column.getColumnComment());
                            }
                            originColumn.setJavaType(TypesMapperUtils.getJavaType(column.getColumnType()));
                            columnService.save(originColumn);
                        }
                        exists = true;
                        break;
                    }
                }
                if(!exists){
                    int sortIdx = TypesMapperUtils.getColumnIdx(column.getColumnName());
                    if(sortIdx > 0){
                        column.setSortIndex(sortIdx);
                    }
                    columnService.save(column);
                }

            }

            // 处理索引信息
            for(EppdevIndex idx : table.getIndexList()){
                idx.setTableId(tableId);
                indexService.save(idx);
            }
        }

    }

    public void generateSource(String versionId) throws IOException {
        List<EppdevTable> tableList = versionService.listTables(versionId).getList();
        for(EppdevTable table : tableList){
            logger.debug("Generate for table: {}", table);
            generatorService.createMapper(table.getId());
            generatorService.createEntity(table.getId());
            generatorService.create_Entity(table.getId());
            generatorService.createService(table.getId());
            generatorService.createDao(table.getId());
        }
    }

    public void init() throws IOException {
        EppdevTable table = new EppdevTable();
        applicationBuildService.build(confService.getBasicMap(), table);
        appPropsBuildService.build(confService.getBasicMap(), table);
        pomBuildService.build(confService.getBasicMap(), table);
    }
}
