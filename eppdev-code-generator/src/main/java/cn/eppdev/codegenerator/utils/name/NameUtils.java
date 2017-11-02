/*
 * FileName: NameBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.utils.name;

import cn.eppdev.utils.string.StringUtils;

/**
 * 名称创建工具类
 *
 * @author: fan.hao
 */
public class NameUtils {

    private static final String WORD_SEPARATOR = "_";

    /**
     * 创建实体类的名称
     *
     * @param tableName 表名
     * @return 实体的名称
     */
    public static String buildEntityName(String tableName) {
        StringBuilder sb = new StringBuilder();
        for (String str : tableName.split(WORD_SEPARATOR)) {
            sb.append(StringUtils.firstUpper(str.toLowerCase()));
        }
        return sb.toString();
    }

    /**
     * 创建字段对应的属性名称
     *
     * @param columnName 字段名
     * @return 对应的属性名称
     */
    public static String buildPropertyName(String columnName) {
        StringBuilder sb = new StringBuilder();
        for (String str : columnName.split(WORD_SEPARATOR)) {
            sb.append(StringUtils.firstUpper(str.toLowerCase()));
        }
        return StringUtils.firstLower(sb.toString());
    }


    public static String buildDaoFileName(String tableName) {
        return buildEntityName(tableName) + "Dao.java";
    }


    public static String buildEntityFileName(String tableName) {
        return buildEntityName(tableName) + ".java";
    }

    public static String build_EntityFileName(String tableName) {
        return "_" + buildEntityName(tableName) + ".java";
    }

    public static String buildServiceFileName(String tableName) {
        return buildEntityName(tableName) + "Service.java";
    }

    public static String buildControllerName(String tableName) {
        return buildEntityName(tableName) + "Controller.java";
    }

    public static String buildMapperFileName(String tableName) {
        return buildEntityName(tableName) + "Dao.xml";
    }

    public static String buildDaoPackageName(String basePackage, String moduleName) {
        String packageName = basePackage;
        if (null != moduleName) {
            packageName += ("." + moduleName);
        }
        packageName += ".dao";
        return packageName;
    }

    public static String buildDaoPackageDir(String basePackage, String moduleName) {
        return buildDaoPackageName(basePackage, moduleName).replace('.', '/');
    }

    public static String buildEntityPackageName(String basePackage, String moduleName) {
        String packageName = basePackage;
        if (null != moduleName) {
            packageName += ("." + moduleName);
        }
        packageName += ".entity";
        return packageName;
    }

    public static String buildEntityPackageDir(String basePackage, String moduleName) {
        return buildEntityPackageName(basePackage, moduleName).replace('.', '/');
    }


    public static String build_EntityPackageName(String basePackage, String moduleName) {
        String packageName = basePackage;
        if (null != moduleName) {
            packageName += ("." + moduleName);
        }
        packageName += ".entity.auto";
        return packageName;
    }

    public static String build_EntityPackageDir(String basePackage, String moduleName) {
        return build_EntityPackageName(basePackage, moduleName).replace('.', '/');
    }


    public static String buildServicePackageName(String basePackage, String moduleName) {
        String packageName = basePackage;
        if (null != moduleName) {
            packageName += ("." + moduleName);
        }
        packageName += ".service";
        return packageName;
    }

    public static String buildServicePackageDir(String basePackage, String moduleName) {
        return buildServicePackageName(basePackage, moduleName).replace('.', '/');
    }




}
