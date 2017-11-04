/*
 * #EppdevIndex.java -- _eppdev_index 对应的映射类，自定义的附加属性请在此增加
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevIndex.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevIndexDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevIndexDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevIndexService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevIndexController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.entity;

import cn.eppdev.test.eppdev.entity.auto._EppdevIndex;
import cn.eppdev.utils.json.JSONUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * _eppdev_index 对应的实体类
 * @author fan.hao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EppdevIndex extends _EppdevIndex {

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}