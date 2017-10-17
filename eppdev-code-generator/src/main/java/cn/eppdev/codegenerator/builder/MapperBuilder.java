/*
 * FileName: MapperBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.TableInfo;

/**
 * @author: fan.hao
 */
public interface MapperBuilder {

    public String createMapper(TableInfo tableInfo);

    public String createMapper(String originContent, TableInfo tableInfo);

}
