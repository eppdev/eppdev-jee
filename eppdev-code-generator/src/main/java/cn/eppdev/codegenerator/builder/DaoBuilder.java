/*
 * FileName: DaoBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.TableInfo;

/**
 * @author: fan.hao
 */
public interface DaoBuilder {
    public String buildDao(TableInfo tableInfo);

    public String build_Dao(TableInfo tableInfo);

    public String build_Dao(String originContent, TableInfo tableInfo);
}
