/*
 * #EppdevDict.java -- _eppdev_dict 对应的映射类，自定义的附加属性请在此增加
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

package cn.eppdev.test.eppdev.entity;

import cn.eppdev.test.eppdev.entity.auto._EppdevDict;
import cn.eppdev.utils.json.JSONUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * _eppdev_dict 对应的实体类
 * @author fan.hao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EppdevDict extends _EppdevDict {

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}