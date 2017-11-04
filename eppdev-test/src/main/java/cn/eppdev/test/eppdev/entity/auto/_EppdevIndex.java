/*
 * #EppdevIndex.java -- _eppdev_index 对应的映射类父类，任何属性请勿在此添加
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevIndex.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevIndexDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevIndexDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevIndexService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevIndexController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * _eppdev_index 对应的实体类父类，请勿做任何修改
 * @author fan.hao
 */
public class _EppdevIndex extends BasicEntity {

    public static final String COLUMN_COLUMN_NAMES_ = "column_names";
    public static final String COLUMN_COLUMN_NAMES_ASC_ = "column_names asc";
    public static final String COLUMN_COLUMN_NAMES_DESC_ = "column_names desc";

    public static final String COLUMN_INDEX_NAME_ = "index_name";
    public static final String COLUMN_INDEX_NAME_ASC_ = "index_name asc";
    public static final String COLUMN_INDEX_NAME_DESC_ = "index_name desc";

    public static final String COLUMN_REMARK_ = "remark";
    public static final String COLUMN_REMARK_ASC_ = "remark asc";
    public static final String COLUMN_REMARK_DESC_ = "remark desc";

    public static final String COLUMN_TABLE_ID_ = "table_id";
    public static final String COLUMN_TABLE_ID_ASC_ = "table_id asc";
    public static final String COLUMN_TABLE_ID_DESC_ = "table_id desc";



    // ---------------------------------
    // column_names的属性
    // ---------------------------------
    private String columnNames;

    // ---------------------------------
    // index_name的属性
    // ---------------------------------
    private String indexName;

    // ---------------------------------
    // remark的属性
    // ---------------------------------
    private String remark;

    // ---------------------------------
    // table_id的属性
    // ---------------------------------
    private String tableId;



    public String getColumnNames() {
        return this.columnNames;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getTableId() {
        return this.tableId;
    }



    public void setColumnNames(String columnNames) {
        this.columnNames =  columnNames;
    }

    public void setIndexName(String indexName) {
        this.indexName =  indexName;
    }

    public void setRemark(String remark) {
        this.remark =  remark;
    }

    public void setTableId(String tableId) {
        this.tableId =  tableId;
    }



}