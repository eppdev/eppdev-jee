/*
 * FileName: EppdevTable.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.codegenerator.manager.entity;

import cn.eppdev.codegenerator.manager.entity.auto._EppdevTable;
import cn.eppdev.utils.json.JSONUtils;

import java.util.List;

/**
 * @author fan.hao
 */
public class EppdevTable extends _EppdevTable {

    private EppdevVersion version;

    private List<EppdevColumn> columnList;

    private List<EppdevIndex> indexList;

    public List<EppdevColumn> getColumnList() {
        return columnList;
    }

    public EppdevVersion getVersion() {
        return version;
    }

    public void setVersion(EppdevVersion version) {
        this.version = version;
    }

    public void setColumnList(List<EppdevColumn> columnList) {
        this.columnList = columnList;
    }

    public List<EppdevIndex> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<EppdevIndex> indexList) {
        this.indexList = indexList;
    }

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}
