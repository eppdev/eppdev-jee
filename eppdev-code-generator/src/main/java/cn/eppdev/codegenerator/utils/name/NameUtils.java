/*
 * FileName: NameBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.utils.name;

import cn.eppdev.utils.string.StringUtils;

/**
 * 名称创建工具类
 * @author: fan.hao
 */
public class NameUtils {

    private static final String WORD_SEPARATOR = "_";

    /**
     * 创建实体类的名称
     * @param tableName 表名
     * @return 实体的名称
     */
    public static String buildEntityName(String tableName){
        StringBuilder sb = new StringBuilder();
        for(String str: tableName.split(WORD_SEPARATOR)){
            sb.append(StringUtils.firstUpper(str.toLowerCase()));
        }
        return sb.toString();
    }

    /**
     * 创建字段对应的属性名称
     * @param columnName 字段名
     * @return 对应的属性名称
     */
    public static String buildPropertyName(String columnName){
        StringBuilder sb = new StringBuilder();
        for(String str: columnName.split(WORD_SEPARATOR)){
            sb.append(StringUtils.firstUpper(str.toLowerCase()));
        }
        return StringUtils.firstLower(sb.toString());
    }


    public static String buildDaoFileName(String tableName){
        return buildEntityName(tableName) + "Dao.java";
    }

    public static String build_DaoFileName(String tableName){
        return  "_" + buildEntityName(tableName) + "Dao.java";
    }


    public static String buildServiceFileName(String tableName){
        return buildEntityName(tableName) + "Service.java";
    }

    public static String buildControllerName(String tableName){
        return buildEntityName(tableName) + "Controller.java";
    }

    public static String buildMapperFIleName(String tableName){
        return buildEntityName(tableName) + "Dao.xml";
    }

}
