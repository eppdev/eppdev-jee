/*
 * FileName: EntityBuildService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-02
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.utils.file.TemplateFileUtils;
import cn.eppdev.codegenerator.utils.name.NameUtils;
import cn.eppdev.utils.template.Template;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fan.hao
 */
@Service
public class EntityBuildService extends BasicBuildService {

    @Override
    protected Template loadTemplate() throws UnsupportedEncodingException {
        if (this.template == null) {
            String templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/Entity.java.template");
            template = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
        }
        return template;
    }

    @Override
    public Map<String, String> buildFieldsMap(EppdevTable eppdevTable, String basicPackageName) {
        return new HashMap<>();
    }

    @Override
    public String buildPackageName(String basicPackageName, String moduleName) {
        return moduleName == null ?
                basicPackageName + ".entity" : basicPackageName + "." + moduleName + ".entity";
    }

    @Override
    public String getSourceDir() {
        return "src/main/java";
    }

    @Override
    public String getFileName(EppdevTable eppdevTable) {
        return NameUtils.buildEntityFileName(eppdevTable.getTableName());
    }

    @Override
    public boolean needUpdate() {
        return false;
    }

    @Override
    public String update(String originContent, EppdevTable eppdevTable, String basicPackageName) {
        return "";
    }
}
