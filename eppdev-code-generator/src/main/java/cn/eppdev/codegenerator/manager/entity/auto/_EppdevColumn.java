/*
 * FileName: EppdevColumn.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.codegenerator.manager.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;

/**
 * @author fan.hao
 */
public class _EppdevColumn extends BasicEntity {

    private String tableId;
    private String columnName;
    private String columnType;
    private Integer columnLength;
    private Integer sortIndex;
    private Boolean primaryKey;
    private String columnComment;
    private String propertyName;
    private String javaType;
    private String originColumnId;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Integer getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(Integer columnLength) {
        this.columnLength = columnLength;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getOriginColumnId() {
        return originColumnId;
    }

    public void setOriginColumnId(String originColumnId) {
        this.originColumnId = originColumnId;
    }
} /* end */
