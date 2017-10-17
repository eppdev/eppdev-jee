/*
 * FileName: TableService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.manager.service;

import cn.eppdev.codegenerator.builder.ColumnBuilder;
import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.manager.entity.EppdevIndex;
import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.utils.name.NameUtils;
import cn.eppdev.commons.service.BasicService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: fan.hao
 */
@Service
@Transactional(readOnly = true)
public class EppdevTableService extends BasicService<EppdevTable> {

    private static Logger logger = LoggerFactory.getLogger(EppdevTableService.class);

    private static final String DEFAULT_VERSION_ID = "00000000000000000000000000000000";

    private static final int DEFAULT_TABLE_TYPE = 200;

    @Autowired
    EppdevColumnService columnService;

    @Autowired
    EppdevIndexService indexService;

    @Autowired
    SchemaService schemaService;

    @Transactional(readOnly = false)
    public int insert(EppdevTable entity) {
        logger.debug("entity: {}", entity);

        // 新增的时候进行必要的处理
        entity.setId(null);
        int result = super.save(entity);

        // 插入默认的字段
        columnService.save(ColumnBuilder.buildId(entity.getId()));
        columnService.save(ColumnBuilder.buildCreateBy(entity.getId()));
        columnService.save(ColumnBuilder.buildCreateTime(entity.getId()));
        columnService.save(ColumnBuilder.buildUpdateTime(entity.getId()));
        columnService.save(ColumnBuilder.buildDelFlag(entity.getId()));
        columnService.save(ColumnBuilder.buildUpdateBy(entity.getId()));

        return result;
    }

    @Override
    @Transactional
    public boolean exists(EppdevTable entity) {
        EppdevTable param = new EppdevTable();
        if (null == entity.getVersionId() || entity.getVersionId().trim().length() == 0) {
            param.setVersionId(DEFAULT_VERSION_ID);
        } else {
            param.setVersionId(entity.getVersionId());
        }
        param.setPageNum(1);
        param.setPageSize(1);
        param.setTableName(entity.getTableName());
        PageInfo<EppdevTable> pageInfo = super.listBy(param);
        if (pageInfo.getTotal() > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void customeInit(EppdevTable entity) {
        // 生成实体名称
        if (null == entity.getEntityName() || entity.getEntityName().trim().length() == 0) {
            entity.setEntityName(NameUtils.buildEntityName(entity.getTableName()));
        }
        // 设置对应的版本ID
        if (null == entity.getVersionId() || entity.getVersionId().trim().length() == 0) {
            entity.setVersionId(DEFAULT_VERSION_ID);
        }
        // 设置默认的表类型
        if (null == entity.getTableType()) {
            entity.setTableType(DEFAULT_TABLE_TYPE);
        }
        entity.setOriginTableId(entity.getId());

    }

    @Override
    public PageInfo<EppdevTable> listLike(EppdevTable paramEntity) {
        if(null == paramEntity.getVersionId()){
            paramEntity.setVersionId(DEFAULT_VERSION_ID);
        }
        return super.listLike(paramEntity);
    }

    @Override
    public PageInfo<EppdevTable> listBy(EppdevTable paramEntity) {
        if(null == paramEntity.getVersionId()){
            paramEntity.setVersionId(DEFAULT_VERSION_ID);
        }
        return super.listBy(paramEntity);
    }

    @Override
    public PageInfo<EppdevTable> listAll() {
        return listBy(new EppdevTable());
    }

    @Override
    @Transactional
    public EppdevTable get(String id) {
        // 获取表的基础信息
        EppdevTable eppdevTable = super.get(id);

        // 获取此表的索引
        EppdevIndex indexParm = new EppdevIndex();
        indexParm.setTableId(id);
        eppdevTable.setIndexList(indexService.listBy(indexParm).getList());

        // 获取此表的列信息
        EppdevColumn columnParam = new EppdevColumn();
        columnParam.setTableId(id);
        columnParam.buildOrderBy("sort_index asc", "create_time");
        eppdevTable.setColumnList(columnService.listBy(columnParam).getList());

        return eppdevTable;
    }
}
