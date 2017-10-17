/*
 * FileName: TestEntityService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 17-9-20
 */

package cn.eppdev.test.service;

import cn.eppdev.commons.service.BasicService;
import cn.eppdev.test.dao.TestEntityDao;
import cn.eppdev.test.entity.TestEntity;
import org.springframework.stereotype.Service;

/**
 * @author: fan.hao
 */
@Service
public class TestEntityService extends BasicService<TestEntity> {

    @Override
    public boolean exists(TestEntity entity) {
        return false;
    }

    @Override
    public void customeInit(TestEntity entity) {

    }
}
