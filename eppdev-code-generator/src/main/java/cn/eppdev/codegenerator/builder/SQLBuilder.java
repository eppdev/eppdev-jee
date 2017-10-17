/*
 * FileName: SQLBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.TableInfo;

/**
 * @author: fan.hao
 */
public interface SQLBuilder {
    public String buildCreate(TableInfo tableInfo);

    public String buildUpdate(TableInfo originTableInfo, TableInfo newTableInfo);
}
