/*
 * FileName: BasicEntity.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.commons.entity;

import cn.eppdev.utils.json.JSONUtils;
import cn.eppdev.utils.string.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Set;

/**
 * @author fan.hao
 */
public class BasicEntity {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_DESC = "id desc";
    public static final String COLUMN_CREATE_TIME = "create_time";
    public static final String COLUMN_CREATE_TIME_DESC = "create_time desc";
    public static final String COLUMN_CREATE_BY = "create_by";
    public static final String COLUMN_UPDATE_TIME = "update_time";
    public static final String COLUMN_UPDATE_TIME_DESC = "update_time desc";
    public static final String COLUMN_UPDATE_BY = "update_by";
    public static final String COLUMN_DEL_FLAG = "del_flag";
    public static final String COLUMN_REMARK = "remark";

    // ---------------------------------
    // name的对应属性
    // ---------------------------------
    private String id;

    // ---------------------------------
    // create_time对应的属性
    // ---------------------------------
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date _minCreateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date _maxCreateTime;

    // ---------------------------------
    // create_by对应的属性
    // ---------------------------------
    private String createBy;

    // ---------------------------------
    // update_time对应的属性
    // ---------------------------------
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date _minUpdateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date _maxUpdateTime;

    // ---------------------------------
    // update_by对应的属性
    // ---------------------------------
    private String updateBy;

    // ---------------------------------
    // del_flag对应的属性
    // ---------------------------------
    private Integer delFlag;
    private Integer _minDelFlag;
    private Integer _maxDelFlag;

    // ---------------------------------
    // remark对应的属性
    // ---------------------------------
    private String remark;

    private String _orderBy;
    private Integer _pageNum;
    private Integer _pageSize;
    private Set<String> _updateProperties;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date get_minCreateTime() {
        return _minCreateTime;
    }

    public void set_minCreateTime(Date _minCreateTime) {
        this._minCreateTime = _minCreateTime;
    }

    public Date get_maxCreateTime() {
        return _maxCreateTime;
    }

    public void set_maxCreateTime(Date _maxCreateTime) {
        this._maxCreateTime = _maxCreateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date get_minUpdateTime() {
        return _minUpdateTime;
    }

    public void set_minUpdateTime(Date _minUpdateTime) {
        this._minUpdateTime = _minUpdateTime;
    }

    public Date get_maxUpdateTime() {
        return _maxUpdateTime;
    }

    public void set_maxUpdateTime(Date _maxUpdateTime) {
        this._maxUpdateTime = _maxUpdateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String get_orderBy() {
        return _orderBy;
    }

    public void set_orderBy(String _orderBy) {
        this._orderBy = _orderBy;
    }

    public Integer get_pageNum() {
        return _pageNum;
    }

    public void set_pageNum(Integer _pageNum) {
        this._pageNum = _pageNum;
    }

    public Integer get_pageSize() {
        return _pageSize;
    }

    public void set_pageSize(Integer _pageSize) {
        this._pageSize = _pageSize;
    }

    public Set<String> get_updateProperties() {
        return _updateProperties;
    }

    public void set_updateProperties(Set<String> _updateProperties) {
        this._updateProperties = _updateProperties;
    }

    public Integer get_minDelFlag() {
        return _minDelFlag;
    }

    public void set_minDelFlag(Integer _minDelFlag) {
        this._minDelFlag = _minDelFlag;
    }

    public Integer get_maxDelFlag() {
        return _maxDelFlag;
    }

    public void set_maxDelFlag(Integer _maxDelFlag) {
        this._maxDelFlag = _maxDelFlag;
    }

    public void buildOrderBy(String... orderbyStrs) {
        StringBuilder sb = new StringBuilder();
        for (String str : orderbyStrs) {
            sb.append(str + ", ");
        }
        this._orderBy = StringUtils.removeEnd(sb.toString().trim(), ",");
    }

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }
}
