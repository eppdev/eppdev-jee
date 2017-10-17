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

    static{
        try {
            TYPE_MAPPING_STD2JAVA.load(TypesMapperUtils.class.getResourceAsStream(TYPE_MAPPER_STD2JAVA_URI));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getJavaType(String stdType){
        return TYPE_MAPPING_STD2JAVA.getProperty(stdType);
    }
}
