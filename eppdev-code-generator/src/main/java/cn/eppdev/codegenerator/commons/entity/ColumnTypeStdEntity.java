/*
 * FileName: ColumnStdEntity.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-15
 */

package cn.eppdev.codegenerator.commons.entity;

/**
 * @author fan.hao
 */
public class ColumnTypeStdEntity {
    private String typeName;
    private boolean needLength;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isNeedLength() {
        return needLength;
    }

    public void setNeedLength(boolean needLength) {
        this.needLength = needLength;
    }
}
