/*
 * #EppdevConf.java -- _eppdev_conf 对应的映射类，自定义的附加属性请在此增加
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevConf.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevConfDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevConfDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevConfService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevConfController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.entity;

import cn.eppdev.test.eppdev.entity.auto._EppdevConf;
import cn.eppdev.utils.json.JSONUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * _eppdev_conf 对应的实体类
 * @author fan.hao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EppdevConf extends _EppdevConf {

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}