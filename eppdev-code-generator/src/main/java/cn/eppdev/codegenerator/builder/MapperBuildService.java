/*
 * FileName: MapperBuildService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-02
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.utils.file.TemplateFileUtils;
import cn.eppdev.codegenerator.utils.name.NameUtils;
import cn.eppdev.utils.template.LineTemplate;
import cn.eppdev.utils.template.Template;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fan.hao
 */
@Service
public class MapperBuildService extends BasicBuildService {

    private Template sqlAsTemplate = null;
    private Template insertTemplate = null;
    private Template updateTemplate = null;
    private Template listByTemplate = null;
    private Template listLikeTemplate = null;
    private Template listLeftLikeTemplate = null;
    private Template listRawLikeTemplate = null;
    private Template countByTemplate = null;
    private Template countLikeTemplate = null;
    private Template loopBindLikeTempate = null;
    private Template loopBindLeftLikeTemplate = null;
    private Template loopBindRawLikeTemplate = null;
    private Template loopWhereByTemplate = null;
    private Template loopWhereByNumberTemplate = null;
    private Template loopWhereLikeTemplate = null;
    private Template loopInsertColumnsTemplate = null;
    private Template loopInsertPropertyTemplate = null;
    private Template loopUpdateSetTempalte = null;

    public MapperBuildService() {
        super();
        String templateContent = null;
        try {
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Sql_As.template");
            sqlAsTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Insert.template");
            insertTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Update.template");
            updateTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_List_By.template");
            listByTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_List_Like.template");
            listLikeTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_List_Left_Like.template");
            listLeftLikeTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_List_Raw_Like.template");
            listRawLikeTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Count_By.template");
            countByTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Count_Like.template");
            countLikeTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Insert_Columns.template");
            loopInsertColumnsTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Insert_Properties.template");
            loopInsertPropertyTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Update_Set.template");
            loopUpdateSetTempalte = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Bind_Like.template");
            loopBindLikeTempate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Bind_Left_Like.template");
            loopBindLeftLikeTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Bind_Raw_Like.template");
            loopBindRawLikeTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Where_By.template");
            loopWhereByTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Where_By_Number.template");
            loopWhereByNumberTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper_Loop_Where_Like.template");
            loopWhereLikeTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected Template loadTemplate() throws UnsupportedEncodingException {
        if (this.template == null) {
            String templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/mapper/Mapper.xml.template");
            template = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
        }
        return template;
    }

    @Override
    public Map<String, String> buildFieldsMap(EppdevTable eppdevTable, String basicPackageName) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.put("SQL_AS", buildSqlAs(eppdevTable));
        map.put("INSERT", buildInsert(eppdevTable, basicPackageName));
        map.put("UPDATE", buildUpdate(eppdevTable, basicPackageName));
        map.put("LIST_BY", buildListBy(eppdevTable, basicPackageName));
        map.put("LIST_LIKE", buildListLike(eppdevTable, basicPackageName));
        map.put("LIST_LEFT_LIKE", buildListLeftLike(eppdevTable, basicPackageName));
        map.put("LIST_RAW_LIKE", buildListRawLike(eppdevTable, basicPackageName));
        map.put("COUNT_BY", buildCountBy(eppdevTable, basicPackageName));
        map.put("COUNT_LIKE", buildCountLike(eppdevTable, basicPackageName));
        return map;
    }

    public String buildSqlAs(EppdevTable eppdevTable) {
        StringBuilder sb = new StringBuilder();
        for (EppdevColumn column : eppdevTable.getColumnList()) {
            sqlAsTemplate.replace(buildFieldsMap(column));
            sb.append(sqlAsTemplate.toString());
        }
        return sb.toString();
    }


    public String buildInsert(EppdevTable eppdevTable, String basicPackageName) {
        StringBuilder stringBuilderProperties = new StringBuilder();
        StringBuilder stringBuilderColumns = new StringBuilder();
        for (EppdevColumn column : eppdevTable.getColumnList()) {
            loopInsertColumnsTemplate.replace(buildFieldsMap(column));
            stringBuilderColumns.append(loopInsertColumnsTemplate.toString());
            loopInsertPropertyTemplate.replace(buildFieldsMap(column));
            stringBuilderProperties.append(loopInsertPropertyTemplate.toString());
        }
        insertTemplate.replace("INSERT_COLUMNS", stringBuilderColumns.toString());
        insertTemplate.replace("INSERT_PROPERTIES", stringBuilderProperties.toString());
        insertTemplate.replace(buildTableMap(eppdevTable, basicPackageName));
        return insertTemplate.toString();
    }

    public String buildUpdate(EppdevTable eppdevTable, String basicPackageName) {
        StringBuilder stringBuilderSet = new StringBuilder();
        for (EppdevColumn column : eppdevTable.getColumnList()) {
            loopUpdateSetTempalte.replace(buildFieldsMap(column));
            stringBuilderSet.append(loopUpdateSetTempalte.toString());
        }
        updateTemplate.replace("UPDATE_SET", stringBuilderSet.toString());
        updateTemplate.replace(buildTableMap(eppdevTable, basicPackageName));
        return updateTemplate.toString();
    }


    public String buildListBy(EppdevTable eppdevTable, String basicPackageName) {
        return buildBasicBy(eppdevTable, basicPackageName, listByTemplate);
    }

    public String buildListLike(EppdevTable eppdevTable, String basicPackageName) {
        return buildBasicLike(eppdevTable, basicPackageName, loopBindLikeTempate, listLikeTemplate);
    }

    public String buildListLeftLike(EppdevTable eppdevTable, String basicPackageName) {
        return buildBasicLike(eppdevTable, basicPackageName, loopBindLeftLikeTemplate, listLeftLikeTemplate);
    }

    public String buildListRawLike(EppdevTable eppdevTable, String basicPackageName) {
        return buildBasicLike(eppdevTable, basicPackageName, loopBindRawLikeTemplate, listRawLikeTemplate);
    }


    public String buildCountBy(EppdevTable eppdevTable, String basicPackageName) {
        return buildBasicBy(eppdevTable, basicPackageName, countByTemplate);
    }

    public String buildCountLike(EppdevTable eppdevTable, String basicPackageName) {
        return buildBasicLike(eppdevTable, basicPackageName, loopBindLeftLikeTemplate, countLikeTemplate);
    }

    public String buildBasicBy(EppdevTable eppdevTable, String basicPackageName,
                               Template byTemplate) {
        StringBuilder sb = new StringBuilder();
        for (EppdevColumn column : eppdevTable.getColumnList()) {
            if (NUMBER_TYPES.contains(column.getJavaType().toUpperCase()) || DATE_TYPES.contains(column.getJavaType().toUpperCase())) {
                loopWhereByNumberTemplate.replace(buildFieldsMap(column));
                sb.append(loopWhereByNumberTemplate.toString());
            } else if (!column.getColumnName().toUpperCase().equals("ID")) {
                loopWhereByTemplate.replace(buildFieldsMap(column));
                sb.append(loopWhereByTemplate.toString());
            }
        }
        byTemplate.replace("WHERE_BY", sb.toString());
        byTemplate.replace(buildTableMap(eppdevTable, basicPackageName));
        return byTemplate.toString();
    }

    public String buildBasicLike(EppdevTable eppdevTable, String basicPackageName,
                                 Template bindTemplate, Template likeTemplate) {
        StringBuilder stringBuilderBind = new StringBuilder();
        StringBuilder stringBuilderWhereBy = new StringBuilder();
        for (EppdevColumn column : eppdevTable.getColumnList()) {
            if (column.getColumnName().toUpperCase().equals("ID")) {
                continue;
            }
            if (column.getJavaType().toUpperCase().equals("STRING")) {
                bindTemplate.replace(buildFieldsMap(column));
                stringBuilderBind.append(bindTemplate.toString());
                loopWhereLikeTemplate.replace(buildFieldsMap(column));
                stringBuilderWhereBy.append(loopWhereLikeTemplate.toString());
            } else if (NUMBER_TYPES.contains(column.getJavaType().toUpperCase()) || DATE_TYPES.contains(column.getJavaType().toUpperCase())) {
                loopWhereByNumberTemplate.replace(buildFieldsMap(column));
                stringBuilderWhereBy.append(loopWhereByNumberTemplate.toString());
            } else {
                loopWhereByTemplate.replace(buildFieldsMap(column));
                stringBuilderWhereBy.append(loopWhereByTemplate.toString());
            }
        }
        likeTemplate.replace("BIND_LIKE", stringBuilderBind.toString());
        likeTemplate.replace("WHERE_LIKE", stringBuilderWhereBy.toString());
        likeTemplate.replace(buildTableMap(eppdevTable, basicPackageName));
        return likeTemplate.toString();
    }

    @Override
    public String buildPackageName(String basicPackageName, String moduleName) {
        return moduleName == null ?
                basicPackageName + ".dao" : basicPackageName + "." + moduleName + ".dao";
    }

    @Override
    public String getSourceDir() {
        return "src/main/resources";
    }

    @Override
    public String getFileName(EppdevTable eppdevTable) {
        return NameUtils.buildMapperFileName(eppdevTable.getTableName());
    }

    @Override
    public boolean needUpdate() {
        return true;
    }

    @Override
    public String update(String originContent, EppdevTable eppdevTable, String basicPackageName) throws IOException {
        LineTemplate lineTemplate = new LineTemplate(new ByteArrayInputStream(originContent.getBytes("UTF-8")));
        return lineTemplate.replace(" id=\"columns\"", "</sql>", buildSqlAs(eppdevTable))
                .replace(" id=\"insert\"", "</insert>", buildInsert(eppdevTable, basicPackageName))
                .replace(" id=\"update\"", "</update>", buildUpdate(eppdevTable, basicPackageName))
                .replace(" id=\"listBy\"", "</select>", buildListBy(eppdevTable, basicPackageName))
                .replace(" id=\"listLike\"", "</select>", buildListLike(eppdevTable, basicPackageName))
                .replace(" id=\"listLeftLike\"", "</select>", buildListLeftLike(eppdevTable, basicPackageName))
                .replace(" id=\"listRawLike\"", "</select>", buildListRawLike(eppdevTable, basicPackageName))
                .replace(" id=\"countBy\"", "</select>", buildCountBy(eppdevTable, basicPackageName))
                .replace(" id=\"countLike\"", "</select>", buildCountLike(eppdevTable, basicPackageName))
                .toString();
    }
}
