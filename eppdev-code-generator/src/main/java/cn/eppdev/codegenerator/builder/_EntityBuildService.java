/*
 * FileName: _EntityBuildService.java
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
public class _EntityBuildService extends BasicBuildService {

    private Template fieldsTemplate = null;

    private Template fieldsNumberTemplate = null;

    private Template fieldsDateTemplate = null;

    private Template staticFieldsTemplate = null;

    private Template getterTemplate = null;

    private Template getterNumberTemplate = null;

    private Template setterTemplate = null;

    private Template setterNumberTemplate = null;

    public _EntityBuildService() throws UnsupportedEncodingException {
        super();
        String templateContent = null;
        try {
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Fields.template");
            fieldsTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Fields_Date.template");
            fieldsDateTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Fields_Number.template");
            fieldsNumberTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));

            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Static_Fields.template");
            staticFieldsTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));

            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Getters.template");
            getterTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Getters_Number.template");
            getterNumberTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));

            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Setters.template");
            setterTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
            templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity_Setters_Number.template");
            setterNumberTemplate = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Template loadTemplate() throws UnsupportedEncodingException {
        if (this.template == null) {
            String templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity.java.template");
            template = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
        }
        return template;
    }

    @Override
    public Map<String, String> buildFieldsMap(EppdevTable eppdevTable, String basicPackageName) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.put("SETTERS", buildSetters(eppdevTable));
        map.put("GETTERS", buildGetters(eppdevTable));
        map.put("FIELDS", buildProperties(eppdevTable));
        map.put("STATIC_FIELDS", buildStaticFields(eppdevTable));
        return map;
    }

    @Override
    public String buildPackageName(String basicPackageName, String moduleName) {
        return moduleName == null ?
                basicPackageName + ".entity.auto" : basicPackageName + "." + moduleName + ".entity.auto";
    }

    @Override
    public String getSourceDir() {
        return "src/main/java";
    }

    @Override
    public String getFileName(EppdevTable eppdevTable) {
        return NameUtils.build_EntityFileName(eppdevTable.getTableName());
    }

    @Override
    public boolean needUpdate() {
        return true;
    }

    @Override
    public String update(String originContent, EppdevTable eppdevTable, String basicPackageName) throws IOException {
        LineTemplate lineTemplate = new LineTemplate(new ByteArrayInputStream(originContent.getBytes("UTF-8")));
        lineTemplate.delAfter("public");
        lineTemplate.addAfter("public",
                buildStaticFields(eppdevTable) + buildProperties(eppdevTable) + buildGetters(eppdevTable) + buildSetters(eppdevTable));
        return lineTemplate.toString() + "}";
    }


    public String buildProperties(EppdevTable eppdevTable) throws UnsupportedEncodingException {
        return buildFieldsBasic(eppdevTable, fieldsDateTemplate, fieldsNumberTemplate, fieldsTemplate);
    }

    public String buildGetters(EppdevTable eppdevTable) throws UnsupportedEncodingException {
        return buildFieldsBasic(eppdevTable, getterNumberTemplate, getterNumberTemplate, getterTemplate);
    }

    public String buildSetters(EppdevTable eppdevTable) throws UnsupportedEncodingException {
        return buildFieldsBasic(eppdevTable, setterNumberTemplate, setterNumberTemplate, setterTemplate);
    }

    public String buildStaticFields(EppdevTable eppdevTable) {
        return buildFieldsBasic(eppdevTable, staticFieldsTemplate, staticFieldsTemplate, staticFieldsTemplate);
    }

    private String buildFieldsBasic(EppdevTable table, Template dateTemplate, Template numberTemplate, Template otherTemplate) {
        StringBuilder sb = new StringBuilder();
        for (EppdevColumn column : table.getColumnList()) {
            Map<String, String> map = buildFieldsMap(column);
            String javaType = column.getJavaType();
            String columnName = column.getColumnName().toUpperCase();
            if (!COMMON_COLUMNS.contains(columnName.toUpperCase())) {
                if (DATE_TYPES.contains(javaType.toUpperCase())) {
                    dateTemplate.replace(map);
                    sb.append(dateTemplate.toString());
                } else if (NUMBER_TYPES.contains(javaType.toUpperCase())) {
                    numberTemplate.replace(map);
                    sb.append(numberTemplate.toString());
                } else {
                    otherTemplate.replace(map);
                    sb.append(otherTemplate.toString());
                }
            }
        }
        return sb.toString();
    }
}
