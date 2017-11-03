/*
 * FileName: TypesMapperUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-14
 */

package cn.eppdev.codegenerator.utils.conf;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * @author fan.hao
 */
public class TypesMapperUtils {


    private static final String TYPE_MAPPER_STD2JAVA_URI = "/eppdev-code-generator/mappings/types/std2java.properties";
    private static Properties TYPE_MAPPING_STD2JAVA = new Properties();

    private static final String TYPE_MAPPER_MYSQL2STD_URI = "/eppdev-code-generator/mappings/types/mysql2std.properties";
    private static Properties TYPE_MAPPING_MYSQL2STD = new Properties();

    private static final String TYPE_MAPPER_NAME2IDX_URI = "/eppdev-code-generator/mappings/types/name2idx.properties";
    private static Properties TYPE_MAPPER_NAME2IDX = new Properties();

    static{
        try {
            TYPE_MAPPING_STD2JAVA.load(TypesMapperUtils.class.getResourceAsStream(TYPE_MAPPER_STD2JAVA_URI));
            TYPE_MAPPING_MYSQL2STD.load(TypesMapperUtils.class.getResourceAsStream(TYPE_MAPPER_MYSQL2STD_URI));
            TYPE_MAPPER_NAME2IDX.load(TypesMapperUtils.class.getResourceAsStream(TYPE_MAPPER_NAME2IDX_URI));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getJavaType(String stdType){
        return TYPE_MAPPING_STD2JAVA.getProperty(stdType);
    }

    public static String getStdFromMysql(String mysqlType){
        return TYPE_MAPPING_MYSQL2STD.getProperty(mysqlType);
    }

    public static int getColumnIdx(String columnName){
        String idx = TYPE_MAPPER_NAME2IDX.getProperty(columnName);
        if(idx == null){
            return -1;
        }
        return Integer.parseInt(idx);
    }
}
