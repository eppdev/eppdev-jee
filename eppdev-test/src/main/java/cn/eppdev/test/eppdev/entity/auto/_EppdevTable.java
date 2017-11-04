/*
 * #EppdevTable.java -- _eppdev_table 对应的映射类父类，任何属性请勿在此添加
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevTable.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevTableDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevTableDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevTableService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevTableController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * _eppdev_table 对应的实体类父类，请勿做任何修改
 * @author fan.hao
 */
public class _EppdevTable extends BasicEntity {

    public static final String COLUMN_ENTITY_NAME_ = "entity_name";
    public static final String COLUMN_ENTITY_NAME_ASC_ = "entity_name asc";
    public static final String COLUMN_ENTITY_NAME_DESC_ = "entity_name desc";

    public static final String COLUMN_MODULE_NAME_ = "module_name";
    public static final String COLUMN_MODULE_NAME_ASC_ = "module_name asc";
    public static final String COLUMN_MODULE_NAME_DESC_ = "module_name desc";

    public static final String COLUMN_CREATE_SQL_ = "create_sql";
    public static final String COLUMN_CREATE_SQL_ASC_ = "create_sql asc";
    public static final String COLUMN_CREATE_SQL_DESC_ = "create_sql desc";

    public static final String COLUMN_ORIGIN_TABLE_ID_ = "origin_table_id";
    public static final String COLUMN_ORIGIN_TABLE_ID_ASC_ = "origin_table_id asc";
    public static final String COLUMN_ORIGIN_TABLE_ID_DESC_ = "origin_table_id desc";

    public static final String COLUMN_TABLE_NAME_ = "table_name";
    public static final String COLUMN_TABLE_NAME_ASC_ = "table_name asc";
    public static final String COLUMN_TABLE_NAME_DESC_ = "table_name desc";

    public static final String COLUMN_TABLE_COMMENT_ = "table_comment";
    public static final String COLUMN_TABLE_COMMENT_ASC_ = "table_comment asc";
    public static final String COLUMN_TABLE_COMMENT_DESC_ = "table_comment desc";

    public static final String COLUMN_REMARK_ = "remark";
    public static final String COLUMN_REMARK_ASC_ = "remark asc";
    public static final String COLUMN_REMARK_DESC_ = "remark desc";

    public static final String COLUMN_TABLE_TYPE_ = "table_type";
    public static final String COLUMN_TABLE_TYPE_ASC_ = "table_type asc";
    public static final String COLUMN_TABLE_TYPE_DESC_ = "table_type desc";

    public static final String COLUMN_VERSION_ID_ = "version_id";
    public static final String COLUMN_VERSION_ID_ASC_ = "version_id asc";
    public static final String COLUMN_VERSION_ID_DESC_ = "version_id desc";



    // ---------------------------------
    // entity_name的属性
    // ---------------------------------
    private String entityName;

    // ---------------------------------
    // module_name的属性
    // ---------------------------------
    private String moduleName;

    // ---------------------------------
    // create_sql的属性
    // ---------------------------------
    private String createSql;

    // ---------------------------------
    // origin_table_id的属性
    // ---------------------------------
    private String originTableId;

    // ---------------------------------
    // table_name的属性
    // ---------------------------------
    private String tableName;

    // ---------------------------------
    // table_comment的属性
    // ---------------------------------
    private String tableComment;

    // ---------------------------------
    // remark的属性
    // ---------------------------------
    private String remark;

    // ---------------------------------
    // table_type的属性
    // ---------------------------------
    private Integer tableType;
    private Integer _maxTableType; // 仅用于查询条件
    private Integer _minTableType; // 仅用于查询条件

    // ---------------------------------
    // version_id的属性
    // ---------------------------------
    private String versionId;



    public String getEntityName() {
        return this.entityName;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String getCreateSql() {
        return this.createSql;
    }

    public String getOriginTableId() {
        return this.originTableId;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getTableComment() {
        return this.tableComment;
    }

    public String getRemark() {
        return this.remark;
    }

    public Integer getTableType() {
        return this.tableType;
    }

    public Integer get_maxTableType() {
        return this._maxTableType;
    }

    public Integer get_minTableType() {
        return this._minTableType;
    }

    public String getVersionId() {
        return this.versionId;
    }



    public void setEntityName(String entityName) {
        this.entityName =  entityName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName =  moduleName;
    }

    public void setCreateSql(String createSql) {
        this.createSql =  createSql;
    }

    public void setOriginTableId(String originTableId) {
        this.originTableId =  originTableId;
    }

    public void setTableName(String tableName) {
        this.tableName =  tableName;
    }

    public void setTableComment(String tableComment) {
        this.tableComment =  tableComment;
    }

    public void setRemark(String remark) {
        this.remark =  remark;
    }

    public void setTableType(Integer tableType) {
        this.tableType =  tableType;
    }

    public void set_maxTableType(Integer _maxTableType) {
        this._maxTableType =  _maxTableType;
    }

    public void set_minTableType(Integer _minTableType) {
        this._minTableType =  _minTableType;
    }

    public void setVersionId(String versionId) {
        this.versionId =  versionId;
    }



}