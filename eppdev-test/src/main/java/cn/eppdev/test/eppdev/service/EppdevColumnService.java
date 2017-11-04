/*
 * # EppdevColumnService.java -- _eppdev_column对应的Service类
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevColumn.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevColumnDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevColumnDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevColumnService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevColumnController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.service;

import cn.eppdev.commons.service.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.eppdev.test.eppdev.entity.EppdevColumn;

/**
 * @author: fan.hao
 */
@Service
@Transactional(readOnly = true)
public class EppdevColumnService extends BasicService<EppdevColumn> {
    private static Logger logger = LoggerFactory.getLogger(EppdevColumnService.class);

        /**
         * 判断是否存在，自定义方法，用于数据插入前的检查
         * @param entity 要检查的数据
         */
        @Override
        public boolean exists(EppdevColumn entity) {
            return false;
            // TODO
        }

        /**
         * 数据的自定义初始化工作，用于保存前的自定义初始化
         * @param entity 要检查的数据
         */
        @Override
        public void customeInit(EppdevColumn entity) {
            // TODO
        }
}
