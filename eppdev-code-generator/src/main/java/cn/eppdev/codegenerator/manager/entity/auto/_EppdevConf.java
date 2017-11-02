/*
 * FileName: _EppdevConf.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-01
 */

package cn.eppdev.codegenerator.manager.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;

/**
 * @author fan.hao
 */
public class _EppdevConf extends BasicEntity{
    private String confName;
    private String confValue;

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getConfValue() {
        return confValue;
    }

    public void setConfValue(String confValue) {
        this.confValue = confValue;
    }
}
