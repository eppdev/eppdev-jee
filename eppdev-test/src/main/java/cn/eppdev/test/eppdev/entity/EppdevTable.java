/*
 * #EppdevTable.java -- _eppdev_table 对应的映射类，自定义的附加属性请在此增加
 * 相关文件如下：
 *      Entity: cn.eppdev.test.eppdev.entity.EppdevTable.java
 *      DAO: cn.eppdev.test.eppdev.dao.EppdevTableDao.java
 *      Mapper: cn.eppdev.test.eppdev.dao.EppdevTableDao.xml([resources/])
 *      Service: cn.eppdev.test.eppdev.service.EppdevTableService.java
 *      Controller: cn.eppdev.test.eppdev.web.EppdevTableController.java
 *
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test.eppdev.entity;

import cn.eppdev.test.eppdev.entity.auto._EppdevTable;
import cn.eppdev.utils.json.JSONUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * _eppdev_table 对应的实体类
 * @author fan.hao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EppdevTable extends _EppdevTable {

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}