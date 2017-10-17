/*
 * FileName: HtmlBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.TableInfo;

/**
 * @author: fan.hao
 */
public interface HtmlBuilder {
    public String createList(TableInfo tableInfo);

    public String createForm(TableInfo tableInfo);
}
