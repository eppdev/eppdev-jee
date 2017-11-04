/*
 * #EppdevVersionDao.java -- _eppdev_version 对应的DAO类，自定义的DAO方法请在此增加，并对应的修改相应的Mapper文件
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevVersion.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevVersionDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevVersionDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevVersionService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevVersionController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.dao;

import cn.eppdev.commons.dao.BasicDao;
import cn.eppdev.test.eppdev.entity.EppdevVersion;

/**
 * _eppdev_version 对应的DAO类
 * @author: fan.hao
 */
public interface EppdevVersionDao extends BasicDao<EppdevVersion> {

}
