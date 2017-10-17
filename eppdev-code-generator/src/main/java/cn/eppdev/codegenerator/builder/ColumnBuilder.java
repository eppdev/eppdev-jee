/*
 * FileName: ColumnBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-14
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.EppdevColumn;

/**
 * @author fan.hao
 */
public class ColumnBuilder {

    /**
     * 创建ID字段
     * @param tableId 表ID
     * @return 要插入的ID字段对象
     */
    public static EppdevColumn buildId(String tableId){
        EppdevColumn column = new EppdevColumn();
        column.setTableId(tableId);
        column.setColumnName("id");
        column.setColumnComment("UUID");
        column.setColumnType("char");
        column.setColumnLength(32);
        column.setJavaType("String");
        column.setPropertyName("id");
        column.setPrimaryKey(true);
        column.setSortIndex(1);
        return column;
    }


    /**
     * 创建create_time字段
     * @param tableId 表id
     * @return 要创建的create_time字段对应额java对象
     */
    public static EppdevColumn buildCreateTime(String tableId){
        EppdevColumn column = new EppdevColumn();
        column.setTableId(tableId);
        column.setColumnName("create_time");
        column.setColumnComment("生成时间");
        column.setColumnType("datetime");
        column.setJavaType("java.util.Date");
        column.setPropertyName("createTime");
        column.setPrimaryKey(false);
        column.setSortIndex(100000);
        return column;
    }

    /**
     * 创建create_by字段
     * @param tableId 表id
     * @return 要创建的create_by字段对应额java对象
     */
    public static EppdevColumn buildCreateBy(String tableId){
        EppdevColumn column = new EppdevColumn();
        column.setTableId(tableId);
        column.setColumnName("create_by");
        column.setColumnComment("创建人");
        column.setColumnType("varchar");
        column.setColumnLength(32);
        column.setJavaType("String");
        column.setPropertyName("createBy");
        column.setPrimaryKey(false);
        column.setSortIndex(100001);
        return column;
    }

    /**
     * 创建update_time字段
     * @param tableId 表id
     * @return 要创建的update_time字段对应额java对象
     */
    public static EppdevColumn buildUpdateTime(String tableId){
        EppdevColumn column = new EppdevColumn();
        column.setTableId(tableId);
        column.setColumnName("update_time");
        column.setColumnComment("修改时间");
        column.setColumnType("datetime");
        column.setJavaType("java.util.Date");
        column.setPropertyName("updateTime");
        column.setPrimaryKey(false);
        column.setSortIndex(100002);
        return column;
    }

    /**
     * 创建update_by字段
     * @param tableId 表id
     * @return 要创建的update_by字段对应额java对象
     */
    public static EppdevColumn buildUpdateBy(String tableId){
        EppdevColumn column = new EppdevColumn();
        column.setTableId(tableId);
        column.setColumnName("update_by");
        column.setColumnComment("修改人");
        column.setColumnType("varchar");
        column.setColumnLength(32);
        column.setJavaType("String");
        column.setPropertyName("createBy");
        column.setPrimaryKey(false);
        column.setSortIndex(100003);
        return column;
    }

    /**
     * 创建del_flag字段
     * @param tableId 表id
     * @return 要创建的del_flag字段对应额java对象
     */
    public static EppdevColumn buildDelFlag(String tableId){
        EppdevColumn column = new EppdevColumn();
        column.setTableId(tableId);
        column.setColumnName("del_flag");
        column.setColumnComment("删除标识");
        column.setColumnType("int");
        column.setJavaType("Integer");
        column.setPropertyName("delFlag");
        column.setPrimaryKey(false);
        column.setSortIndex(100004);
        return column;
    }



}
