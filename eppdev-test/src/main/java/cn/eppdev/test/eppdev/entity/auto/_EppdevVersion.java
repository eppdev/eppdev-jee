/*
 * #EppdevVersion.java -- _eppdev_version 对应的映射类父类，任何属性请勿在此添加
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

package cn.eppdev.test.eppdev.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * _eppdev_version 对应的实体类父类，请勿做任何修改
 * @author fan.hao
 */
public class _EppdevVersion extends BasicEntity {

    public static final String COLUMN_REMARK_ = "remark";
    public static final String COLUMN_REMARK_ASC_ = "remark asc";
    public static final String COLUMN_REMARK_DESC_ = "remark desc";

    public static final String COLUMN_VERSION_NAME_ = "version_name";
    public static final String COLUMN_VERSION_NAME_ASC_ = "version_name asc";
    public static final String COLUMN_VERSION_NAME_DESC_ = "version_name desc";



    // ---------------------------------
    // remark的属性
    // ---------------------------------
    private String remark;

    // ---------------------------------
    // version_name的属性
    // ---------------------------------
    private String versionName;



    public String getRemark() {
        return this.remark;
    }

    public String getVersionName() {
        return this.versionName;
    }



    public void setRemark(String remark) {
        this.remark =  remark;
    }

    public void setVersionName(String versionName) {
        this.versionName =  versionName;
    }



}