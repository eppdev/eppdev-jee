/*
 * FileName: EntityBuilder.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-31
 */

package cn.eppdev.codegenerator.builder;

import cn.eppdev.codegenerator.manager.entity.EppdevTable;

/**
 * @author fan.hao
 */
public interface EntityBuilder {

    public String buildEntity(EppdevTable eppdevTable);

    public String build_Entity(EppdevTable eppdevTable);
}
