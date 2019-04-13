package com.example.springboot1.dto;

import java.io.Serializable;

/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: accessInfo
 * @Package com.intellif.community.bus.entity
 * @Description
 * @date 2018/8/27 11:24
 */
public class AccessInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**门禁id*/
    private Long accessId;
    /**门禁名称*/
    private String accessName;
    /**门禁型号*/
    private String accessModel;
    /**生产厂家*/
    private String productFactory;
    /**门禁状态 1：在线，0：离线，-1：未激活*/
    private Integer status;
    /**工作模式 0：视频，1：磁卡，2：声音，3指纹*/
    private Integer workMode;
    /**门禁地区Id*/
    private Long addressId;
    /**门禁地区名称*/
    private String addressName;
    /**门禁所以父类地址Id*/
    private String addressParentId;
    /**baseUrl*/
    private String baseUrl;
    /**token*/
    private String token;
    /**创建时间*/
    private String createTime;
    /**创建人*/
    private Long createId;
    /**修改时间*/
    private String updateTime;
    /**修改人*/
    private Long updateId;


    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public String getAccessModel() {
        return accessModel;
    }

    public void setAccessModel(String accessModel) {
        this.accessModel = accessModel;
    }

    public String getProductFactory() {
        return productFactory;
    }

    public void setProductFactory(String productFactory) {
        this.productFactory = productFactory;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressParentId() {
        return addressParentId;
    }

    public void setAddressParentId(String addressParentId) {
        this.addressParentId = addressParentId;
    }
}
