/*
 * #EppdevConf.java -- _eppdev_conf 对应的映射类父类，任何属性请勿在此添加
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

package cn.eppdev.test.eppdev.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * _eppdev_conf 对应的实体类父类，请勿做任何修改
 * @author fan.hao
 */
public class _EppdevConf extends BasicEntity {

    public static final String COLUMN_CONF_NAME_ = "conf_name";
    public static final String COLUMN_CONF_NAME_ASC_ = "conf_name asc";
    public static final String COLUMN_CONF_NAME_DESC_ = "conf_name desc";

    public static final String COLUMN_CONF_VALUE_ = "conf_value";
    public static final String COLUMN_CONF_VALUE_ASC_ = "conf_value asc";
    public static final String COLUMN_CONF_VALUE_DESC_ = "conf_value desc";

    public static final String COLUMN_REMARK_ = "remark";
    public static final String COLUMN_REMARK_ASC_ = "remark asc";
    public static final String COLUMN_REMARK_DESC_ = "remark desc";



    // ---------------------------------
    // conf_name的属性
    // ---------------------------------
    private String confName;

    // ---------------------------------
    // conf_value的属性
    // ---------------------------------
    private String confValue;

    // ---------------------------------
    // remark的属性
    // ---------------------------------
    private String remark;



    public String getConfName() {
        return this.confName;
    }

    public String getConfValue() {
        return this.confValue;
    }

    public String getRemark() {
        return this.remark;
    }



    public void setConfName(String confName) {
        this.confName =  confName;
    }

    public void setConfValue(String confValue) {
        this.confValue =  confValue;
    }

    public void setRemark(String remark) {
        this.remark =  remark;
    }



}