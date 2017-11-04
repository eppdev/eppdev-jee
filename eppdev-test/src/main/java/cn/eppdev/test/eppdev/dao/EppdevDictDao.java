/*
 * #EppdevDictDao.java -- _eppdev_dict 对应的DAO类，自定义的DAO方法请在此增加，并对应的修改相应的Mapper文件
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevDict.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevDictDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevDictDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevDictService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevDictController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.dao;

import cn.eppdev.commons.dao.BasicDao;
import cn.eppdev.test.eppdev.entity.EppdevDict;

/**
 * _eppdev_dict 对应的DAO类
 * @author: fan.hao
 */
public interface EppdevDictDao extends BasicDao<EppdevDict> {

}
