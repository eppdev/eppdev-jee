/*
 * FileName: EppdevIndex.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.codegenerator.manager.entity;

import cn.eppdev.codegenerator.manager.entity.auto._EppdevIndex;
import cn.eppdev.utils.json.JSONUtils;

/**
 * @author fan.hao
 */
public class EppdevIndex extends _EppdevIndex {
    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}
