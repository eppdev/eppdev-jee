/*
 * FileName: TestEntity.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.test.entity;

import cn.eppdev.test.entity.auto._TestEntity;
import cn.eppdev.utils.json.JSONUtils;

/**
 * @author fan.hao
 */
public class TestEntity extends _TestEntity {

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}
