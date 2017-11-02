/*
 * FileName: TemplateMapBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-01
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.utils.name.NameUtils;
import cn.eppdev.utils.date.DateUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fan.hao
 */
public class TemplateMapBuilder {
    public static Map<String, String> buildTableMap(EppdevTable eppdevTable){
        Map<String, String> result = buildBasicMap();
        result.put("TABLE_NAME", eppdevTable.getTableName());
        if(eppdevTable.getEntityName() != null) {
            result.put("ENTITY_NAME", eppdevTable.getEntityName());
        }
        else{
            result.put("ENTITY_NAME", NameUtils.buildEntityName(eppdevTable.getTableName()));
        }
        if(eppdevTable.getModuleName() != null){
            result.put("MODULE_NAME_PKG", "." + eppdevTable.getModuleName());
            result.put("MODULE_NAME_DIR", "/" + eppdevTable.getModuleName());
        } else {
            result.put("MODULE_NAME_DIR", "");
            result.put("MODULE_NAME_PKG", "");
        }
        return result;
    }


    public static Map<String, String> buildBasicMap(){
        Map<String, String> result = new HashMap<>();
        result.put("DATE", DateUtils.getCurrentDate());
        result.put("DATETIME", DateUtils.getCurrentDateTime());
        return result;
    }
}
