/*
 * FileName: EppdevTable.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.codegenerator.manager.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;

import java.util.Date;

/**
 * @author fan.hao
 */
public class _EppdevTable extends BasicEntity {
    private String tableName;
    private String tableComment;
    private String entityName;
    private String moduleName;
    private Integer tableType;
    private String versionId;
    private String createSql;
    private String originTableId;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getTableType() {
        return tableType;
    }

    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getCreateSql() {
        return createSql;
    }

    public void setCreateSql(String createSql) {
        this.createSql = createSql;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getOriginTableId() {
        return originTableId;
    }

    public void setOriginTableId(String originTableId) {
        this.originTableId = originTableId;
    }
}
