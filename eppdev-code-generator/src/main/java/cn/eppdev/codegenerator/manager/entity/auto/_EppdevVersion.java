/*
 * FileName: EppdevVersion.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.codegenerator.manager.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;

/**
 * @author fan.hao
 */
public class _EppdevVersion extends BasicEntity {
    private String versionName;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
