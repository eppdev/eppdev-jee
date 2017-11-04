/*
 * #EppdevDict.java -- _eppdev_dict 对应的映射类父类，任何属性请勿在此添加
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

package cn.eppdev.test.eppdev.entity.auto;

import cn.eppdev.commons.entity.BasicEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * _eppdev_dict 对应的实体类父类，请勿做任何修改
 * @author fan.hao
 */
public class _EppdevDict extends BasicEntity {

    public static final String COLUMN_REMARK_ = "remark";
    public static final String COLUMN_REMARK_ASC_ = "remark asc";
    public static final String COLUMN_REMARK_DESC_ = "remark desc";

    public static final String COLUMN_CODE_ = "code";
    public static final String COLUMN_CODE_ASC_ = "code asc";
    public static final String COLUMN_CODE_DESC_ = "code desc";

    public static final String COLUMN_LABEL_ = "label";
    public static final String COLUMN_LABEL_ASC_ = "label asc";
    public static final String COLUMN_LABEL_DESC_ = "label desc";

    public static final String COLUMN_DICT_TYPE_ = "dict_type";
    public static final String COLUMN_DICT_TYPE_ASC_ = "dict_type asc";
    public static final String COLUMN_DICT_TYPE_DESC_ = "dict_type desc";



    // ---------------------------------
    // remark的属性
    // ---------------------------------
    private String remark;

    // ---------------------------------
    // code的属性
    // ---------------------------------
    private Integer code;
    private Integer _maxCode; // 仅用于查询条件
    private Integer _minCode; // 仅用于查询条件

    // ---------------------------------
    // label的属性
    // ---------------------------------
    private String label;

    // ---------------------------------
    // dict_type的属性
    // ---------------------------------
    private String dictType;



    public String getRemark() {
        return this.remark;
    }

    public Integer getCode() {
        return this.code;
    }

    public Integer get_maxCode() {
        return this._maxCode;
    }

    public Integer get_minCode() {
        return this._minCode;
    }

    public String getLabel() {
        return this.label;
    }

    public String getDictType() {
        return this.dictType;
    }



    public void setRemark(String remark) {
        this.remark =  remark;
    }

    public void setCode(Integer code) {
        this.code =  code;
    }

    public void set_maxCode(Integer _maxCode) {
        this._maxCode =  _maxCode;
    }

    public void set_minCode(Integer _minCode) {
        this._minCode =  _minCode;
    }

    public void setLabel(String label) {
        this.label =  label;
    }

    public void setDictType(String dictType) {
        this.dictType =  dictType;
    }



}