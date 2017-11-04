/*
 * #EppdevColumn.java -- _eppdev_column 对应的映射类父类，任何属性请勿在此添加
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevColumn.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevColumnDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevColumnDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevColumnService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevColumnController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * _eppdev_column 对应的实体类父类，请勿做任何修改
 * @author fan.hao
 */
public class _EppdevColumn extends BasicEntity {

    public static final String COLUMN_JAVA_TYPE_ = "java_type";
    public static final String COLUMN_JAVA_TYPE_ASC_ = "java_type asc";
    public static final String COLUMN_JAVA_TYPE_DESC_ = "java_type desc";

    public static final String COLUMN_SORT_INDEX_ = "sort_index";
    public static final String COLUMN_SORT_INDEX_ASC_ = "sort_index asc";
    public static final String COLUMN_SORT_INDEX_DESC_ = "sort_index desc";

    public static final String COLUMN_COLUMN_NAME_ = "column_name";
    public static final String COLUMN_COLUMN_NAME_ASC_ = "column_name asc";
    public static final String COLUMN_COLUMN_NAME_DESC_ = "column_name desc";

    public static final String COLUMN_ORIGIN_COLUMN_ID_ = "origin_column_id";
    public static final String COLUMN_ORIGIN_COLUMN_ID_ASC_ = "origin_column_id asc";
    public static final String COLUMN_ORIGIN_COLUMN_ID_DESC_ = "origin_column_id desc";

    public static final String COLUMN_TABLE_ID_ = "table_id";
    public static final String COLUMN_TABLE_ID_ASC_ = "table_id asc";
    public static final String COLUMN_TABLE_ID_DESC_ = "table_id desc";

    public static final String COLUMN_COLUMN_TYPE_ = "column_type";
    public static final String COLUMN_COLUMN_TYPE_ASC_ = "column_type asc";
    public static final String COLUMN_COLUMN_TYPE_DESC_ = "column_type desc";

    public static final String COLUMN_PROPERTY_NAME_ = "property_name";
    public static final String COLUMN_PROPERTY_NAME_ASC_ = "property_name asc";
    public static final String COLUMN_PROPERTY_NAME_DESC_ = "property_name desc";

    public static final String COLUMN_COLUMN_COMMENT_ = "column_comment";
    public static final String COLUMN_COLUMN_COMMENT_ASC_ = "column_comment asc";
    public static final String COLUMN_COLUMN_COMMENT_DESC_ = "column_comment desc";

    public static final String COLUMN_PRIMARY_KEY_ = "primary_key";
    public static final String COLUMN_PRIMARY_KEY_ASC_ = "primary_key asc";
    public static final String COLUMN_PRIMARY_KEY_DESC_ = "primary_key desc";

    public static final String COLUMN_COLUMN_LENGTH_ = "column_length";
    public static final String COLUMN_COLUMN_LENGTH_ASC_ = "column_length asc";
    public static final String COLUMN_COLUMN_LENGTH_DESC_ = "column_length desc";

    public static final String COLUMN_REMARK_ = "remark";
    public static final String COLUMN_REMARK_ASC_ = "remark asc";
    public static final String COLUMN_REMARK_DESC_ = "remark desc";



    // ---------------------------------
    // java_type的属性
    // ---------------------------------
    private String javaType;

    // ---------------------------------
    // sort_index的属性
    // ---------------------------------
    private Integer sortIndex;
    private Integer _maxSortIndex; // 仅用于查询条件
    private Integer _minSortIndex; // 仅用于查询条件

    // ---------------------------------
    // column_name的属性
    // ---------------------------------
    private String columnName;

    // ---------------------------------
    // origin_column_id的属性
    // ---------------------------------
    private String originColumnId;

    // ---------------------------------
    // table_id的属性
    // ---------------------------------
    private String tableId;

    // ---------------------------------
    // column_type的属性
    // ---------------------------------
    private String columnType;

    // ---------------------------------
    // property_name的属性
    // ---------------------------------
    private String propertyName;

    // ---------------------------------
    // column_comment的属性
    // ---------------------------------
    private String columnComment;

    // ---------------------------------
    // primary_key的属性
    // ---------------------------------
    private Boolean primaryKey;

    // ---------------------------------
    // column_length的属性
    // ---------------------------------
    private Integer columnLength;
    private Integer _maxColumnLength; // 仅用于查询条件
    private Integer _minColumnLength; // 仅用于查询条件

    // ---------------------------------
    // remark的属性
    // ---------------------------------
    private String remark;



    public String getJavaType() {
        return this.javaType;
    }

    public Integer getSortIndex() {
        return this.sortIndex;
    }

    public Integer get_maxSortIndex() {
        return this._maxSortIndex;
    }

    public Integer get_minSortIndex() {
        return this._minSortIndex;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getOriginColumnId() {
        return this.originColumnId;
    }

    public String getTableId() {
        return this.tableId;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public String getColumnComment() {
        return this.columnComment;
    }

    public Boolean getPrimaryKey() {
        return this.primaryKey;
    }

    public Integer getColumnLength() {
        return this.columnLength;
    }

    public Integer get_maxColumnLength() {
        return this._maxColumnLength;
    }

    public Integer get_minColumnLength() {
        return this._minColumnLength;
    }

    public String getRemark() {
        return this.remark;
    }



    public void setJavaType(String javaType) {
        this.javaType =  javaType;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex =  sortIndex;
    }

    public void set_maxSortIndex(Integer _maxSortIndex) {
        this._maxSortIndex =  _maxSortIndex;
    }

    public void set_minSortIndex(Integer _minSortIndex) {
        this._minSortIndex =  _minSortIndex;
    }

    public void setColumnName(String columnName) {
        this.columnName =  columnName;
    }

    public void setOriginColumnId(String originColumnId) {
        this.originColumnId =  originColumnId;
    }

    public void setTableId(String tableId) {
        this.tableId =  tableId;
    }

    public void setColumnType(String columnType) {
        this.columnType =  columnType;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName =  propertyName;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment =  columnComment;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey =  primaryKey;
    }

    public void setColumnLength(Integer columnLength) {
        this.columnLength =  columnLength;
    }

    public void set_maxColumnLength(Integer _maxColumnLength) {
        this._maxColumnLength =  _maxColumnLength;
    }

    public void set_minColumnLength(Integer _minColumnLength) {
        this._minColumnLength =  _minColumnLength;
    }

    public void setRemark(String remark) {
        this.remark =  remark;
    }



}