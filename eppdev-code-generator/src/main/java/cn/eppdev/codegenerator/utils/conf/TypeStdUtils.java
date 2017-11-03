/*
 * FileName: ColumnStdUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-15
 */

package cn.eppdev.codegenerator.utils.conf;

import cn.eppdev.codegenerator.commons.entity.ColumnTypeStdEntity;

import java.io.IOException;
import java.util.*;

/**
 * @author fan.hao
 */
public class TypeStdUtils {

    private static final String TYPE_MAPPER_TYPE_STD_URI = "/eppdev-code-generator/mappings/types/type_std.properties";
    private static Properties TYPE_MAPPING_TYPE_STD = new Properties();

    // 读取配置文件
    static {
        try {
            TYPE_MAPPING_TYPE_STD.load(TypesMapperUtils.class.getResourceAsStream(TYPE_MAPPER_TYPE_STD_URI));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取标准数据类型配置数据
     * @return 标准配置数据
     */
    public static List<ColumnTypeStdEntity> getColumnStdList() {
        List<ColumnTypeStdEntity> result = new ArrayList<>();
        for (Object obj : TYPE_MAPPING_TYPE_STD.keySet()) {
            ColumnTypeStdEntity typeStdEntity = new ColumnTypeStdEntity();
            typeStdEntity.setTypeName(obj.toString());
            typeStdEntity.setNeedLength(false);
            String needLengthStr = TYPE_MAPPING_TYPE_STD.getProperty(obj.toString());
            if (needLengthStr.equals("true")) {
                typeStdEntity.setNeedLength(true);
            }
            result.add(typeStdEntity);
        }
        return result;
    }

    public static Map<String, Boolean> needLengthConf(){
        Map<String, Boolean> result = new HashMap<>();
        for(ColumnTypeStdEntity entity : getColumnStdList()){
            result.put(entity.getTypeName(), entity.isNeedLength());
        }
        return result;
    }

}
