/*
 * FileName: BasicBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-02
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.utils.file.SourceFileUtils;
import cn.eppdev.codegenerator.utils.name.NameUtils;
import cn.eppdev.utils.date.DateUtils;
import cn.eppdev.utils.string.StringUtils;
import cn.eppdev.utils.template.Template;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fan.hao
 */
public abstract class BasicBuildService {

    protected List<String> NUMBER_TYPES = null;

    protected List<String> DATE_TYPES = null;

    protected List<String> COMMON_COLUMNS = null;

    public BasicBuildService() {
        String[] numberTypes = {"INTEGER", "FLOAT", "DOUBLE", "LONG"};
        String[] dataTypes = {"JAVA.UTIL.DATE"};
        String[] commonColumns = {"ID", "CREATE_TIME", "UPDATE_TIME", "CREATE_BY", "UPDATE_BY", "DEL_FLAG"};
        NUMBER_TYPES = Arrays.asList(numberTypes);
        DATE_TYPES = Arrays.asList(dataTypes);
        COMMON_COLUMNS = Arrays.asList(commonColumns);
    }

    protected Template template = null;

    /**
     * 读取模板
     *
     * @return
     */
    protected abstract Template loadTemplate() throws UnsupportedEncodingException;

    /**
     * 进行创建文件
     *
     * @param globalMap
     * @param table
     * @throws IOException
     */
    public void build(Map<String, String> globalMap, EppdevTable table) throws IOException {
        String workSpaceDir = globalMap.get("WORK_SPACE_DIR");
        String projectName = globalMap.get("PROJECT_NAME");
        String basicPackageName = globalMap.get("BASIC_PACKAGE_NAME");
        String srcDir = getSourceDir();
        String packageName = buildPackageName(basicPackageName, table.getModuleName());
        String fileName = getFileName(table);
        if (!SourceFileUtils.exists(workSpaceDir, projectName, srcDir, packageName, fileName)) {
            Template template = loadTemplate();
            template.replace(globalMap, buildTableMap(table, basicPackageName), buildFieldsMap(table, basicPackageName));
            SourceFileUtils.writeSourceFile(workSpaceDir, projectName, srcDir, packageName, fileName, template.toString());
        } else if (needUpdate()) {
            String originContent = SourceFileUtils.readSourceFileToString(workSpaceDir, projectName, srcDir, packageName, fileName);
            SourceFileUtils.writeSourceFile(workSpaceDir, projectName, srcDir, packageName, fileName, update(originContent, table, basicPackageName));
        }

    }

    public Map<String, String> buildTableMap(EppdevTable eppdevTable, String basicPackageName) {
        Map<String, String> result = new HashMap<>();
        result.put("DATE", DateUtils.getCurrentDate());
        result.put("DATETIME", DateUtils.getCurrentDateTime());
        if (null != eppdevTable && null != eppdevTable.getTableName()) {
            result.put("TABLE_NAME", eppdevTable.getTableName());
            result.put("ENTITY_NAME", eppdevTable.getEntityName() == null ?
                    NameUtils.buildEntityName(eppdevTable.getTableName()) : eppdevTable.getEntityName());
            if (eppdevTable.getModuleName() == null) {
                result.put("PACKAGE_NAME_DAO", basicPackageName + ".dao");
                result.put("PACKAGE_NAME_SERVICE", basicPackageName + ".service");
                result.put("PACKAGE_NAME_ENTITY", basicPackageName + ".entity");
                result.put("PACKAGE_NAME_CONTROLLER", basicPackageName + ".web");
            } else {
                result.put("PACKAGE_NAME_DAO", basicPackageName + "." + eppdevTable.getModuleName() + ".dao");
                result.put("PACKAGE_NAME_SERVICE", basicPackageName + "." + eppdevTable.getModuleName() + ".service");
                result.put("PACKAGE_NAME_ENTITY", basicPackageName + "." + eppdevTable.getModuleName() + ".entity");
                result.put("PACKAGE_NAME_CONTROLLER", basicPackageName + "." + eppdevTable.getModuleName() + ".web");
            }
        }
        return result;
    }

    public Map<String, String> buildFieldsMap(EppdevColumn column) {
        Map<String, String> map = new HashMap<>();
        map.put("JAVA_TYPE", column.getJavaType());
        map.put("COLUMN_NAME", column.getColumnName());
        map.put("COLUMN_COMMENT", column.getColumnComment());
        map.put("PROPERTY_NAME", column.getPropertyName() == null ?
                NameUtils.buildPropertyName(column.getColumnName()) : column.getPropertyName());
        map.put("PROPERTY_NAME_UP", StringUtils.firstUpper(map.get("PROPERTY_NAME")));
        map.put("COLUMN_NAME_UP", column.getColumnName().toUpperCase());
        return map;
    }

    public abstract Map<String, String> buildFieldsMap(EppdevTable eppdevTable, String basicPackageName) throws UnsupportedEncodingException;

    public abstract String buildPackageName(String basicPackageName, String moduleName);

    public abstract String getSourceDir();

    public abstract String getFileName(EppdevTable eppdevTable);

    public abstract boolean needUpdate();

    public abstract String update(String originContent, EppdevTable eppdevTable, String basicPackageName) throws IOException;

}
