/*
 * FileName: TableInfo.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.manager.entity;

import java.util.List;
import java.util.Map;

/**
 * 表信息
 * @author: fan.hao
 */
public class TableInfo {
    // 表的基础信息
    private Map<String, Object> basicInfo;
    // 字段信息
    private List<Map<String, Object>> columnList;
    // 索引信息
    private List<Map<String, Object>> indexList;

    
    public Map<String, Object> getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(Map<String, Object> basicInfo) {
        this.basicInfo = basicInfo;
    }

    public List<Map<String, Object>> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Map<String, Object>> columnList) {
        this.columnList = columnList;
    }

    public List<Map<String, Object>> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<Map<String, Object>> indexList) {
        this.indexList = indexList;
    }
}
