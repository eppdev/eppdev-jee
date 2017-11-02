/*
 * FileName: GeneratorService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-01
 */

package cn.eppdev.codegenerator.manager.service;

import cn.eppdev.codegenerator.builder.TemplateMapBuilder;
import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.utils.file.SourceFileUtils;
import cn.eppdev.codegenerator.utils.file.TemplateFileUtils;
import cn.eppdev.codegenerator.utils.name.NameUtils;
import cn.eppdev.utils.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author fan.hao
 */
@Service
public class GeneratorService {

    @Autowired
    EppdevTableService tableService;

    @Autowired
    EppdevConfService confService;


    public void createDao(String tableId) {
        EppdevTable table = tableService.get(tableId);
        String packageName = NameUtils.buildDaoPackageName(confService.getBasicPackageName(), table.getModuleName());
        String packageDir = NameUtils.buildDaoPackageDir(confService.getBasicPackageName(), table.getModuleName());
        if (!SourceFileUtils.exists(confService.getWorkSpaceDir(),
                confService.getProjectName(),
                "/src/main/java", packageName,
                NameUtils.buildDaoFileName(table.getTableName()))) {
            try {
                String templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/dao/Dao.java.template");
                Template template = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
                template.replace(confService.getBasicMap());
                template.replace(TemplateMapBuilder.buildTableMap(table));
                template.replace("PACKAGE_NAME", confService.getBasicPackageName());
                template.replace("PACKAGE_DIR", packageDir);
                SourceFileUtils.writeSourceFile(confService.getWorkSpaceDir(),
                        confService.getProjectName(),
                        "/src/main/java", packageName,
                        NameUtils.buildDaoFileName(table.getTableName()),
                        template.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createEntity(String tableId) {
        EppdevTable table = tableService.get(tableId);
        String packageName = NameUtils.buildEntityPackageName(confService.getBasicPackageName(), table.getModuleName());
        String packageDir = NameUtils.buildEntityPackageDir(confService.getBasicPackageName(), table.getModuleName());
        if (!SourceFileUtils.exists(confService.getWorkSpaceDir(),
                confService.getProjectName(), "src/main/java", packageName,
                NameUtils.buildEntityFileName(table.getTableName()))) {
            try {
                String templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/Entity.java.template");
                Template template = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
                template.replace(confService.getBasicMap());
                template.replace(TemplateMapBuilder.buildTableMap(tableService.get(tableId)));
                template.replace("PACKAGE_NAME", confService.getBasicPackageName());
                template.replace("PACKAGE_DIR", packageDir);
                SourceFileUtils.writeSourceFile(confService.getWorkSpaceDir(),
                        confService.getProjectName(),
                        "/src/main/java", packageName,
                        NameUtils.buildEntityFileName(table.getTableName()),
                        template.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void create_Entity(String tableId) {
        EppdevTable table = tableService.get(tableId);
        String packageName = NameUtils.build_EntityPackageName(confService.getBasicPackageName(), table.getModuleName());
        String packageDir = NameUtils.build_EntityPackageDir(confService.getBasicPackageName(), table.getModuleName());
        if (!SourceFileUtils.exists(confService.getWorkSpaceDir(),
                confService.getProjectName(), "src/main/java", packageName,
                NameUtils.build_EntityFileName(table.getTableName()))) {
            try {
                String templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/entity/_Entity.java.template");
                Template template = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
                template.replace(confService.getBasicMap());
                template.replace(TemplateMapBuilder.buildTableMap(tableService.get(tableId)));
                template.replace("PACKAGE_NAME", confService.getBasicPackageName());
                template.replace("PACKAGE_DIR", packageDir);
                SourceFileUtils.writeSourceFile(confService.getWorkSpaceDir(),
                        confService.getProjectName(),
                        "/src/main/java", packageName,
                        NameUtils.build_EntityFileName(table.getTableName()),
                        template.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createService(String tableId) {
        EppdevTable table = tableService.get(tableId);
        String packageName = NameUtils.buildServicePackageName(confService.getBasicPackageName(), table.getModuleName());
        String packageDir = NameUtils.buildServicePackageDir(confService.getBasicPackageName(), table.getModuleName());
        if (!SourceFileUtils.exists(confService.getWorkSpaceDir(),
                confService.getProjectName(), "src/main/java", packageName,
                NameUtils.buildServiceFileName(table.getTableName()))) {
            try {
                String templateContent = TemplateFileUtils.read("/eppdev-code-generator/templates/service/Service.java.template");
                Template template = new Template(new ByteArrayInputStream(templateContent.getBytes("UTF-8")));
                template.replace(confService.getBasicMap());
                template.replace(TemplateMapBuilder.buildTableMap(tableService.get(tableId)));
                template.replace("PACKAGE_NAME", confService.getBasicPackageName());
                template.replace("PACKAGE_DIR", packageDir);
                SourceFileUtils.writeSourceFile(confService.getWorkSpaceDir(),
                        confService.getProjectName(),
                        "/src/main/java", packageName,
                        NameUtils.buildServiceFileName(table.getTableName()),
                        template.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
