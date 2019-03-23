package com.mass.biz.smart.services.Contract.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 合同管理
 * @Author 郑上进
 * @Date 2018/8/7 9:53
 * @Version 1.0
 **/
public class Contract implements Serializable {

    /*系统*/
    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除状态
     */
    private Integer delFlag;

    /*合同管理*/

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 合同到期时间
     */
    private String expiryTime;

    /**
     * 合同到期时间提醒
     */
    private Long expiryTimeTx;

    /**
     * 合同附件路径
     */
    private String contractUrl;

    /**
     * 合同附件名字
     */
    private String contractUrlName;

    /**
     * 合同状态(0.正常，1.将到期，2已到期)
     */
    private Integer contractState;

    /**
     * 合同所属公司id
     */
    private Long companyId;

    /**
     * 合同类型(0.租赁合同，1.其他合同)
     */
    private Integer contractType;

    /**
     * 所属公司名称
     */
    private String companyName;

    /**
     * 公司名称
     */
    private String corporateName;

    /**
     * 公司简称
     */
    private String abbreviation;

    /**
     * 法定代表人
     */
    private String representativeName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 问价路径
     */
    private String filePath;
    
    
    /**
     * 用户该合同签订者的用户id
     */
    private String userId;
    

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public Long getExpiryTimeTx() {
        return expiryTimeTx;
    }

    public void setExpiryTimeTx(Long expiryTimeTx) {
        this.expiryTimeTx = expiryTimeTx;
    }

    public String getContractUrlName() {
        return contractUrlName;
    }

    public void setContractUrlName(String contractUrlName) {
        this.contractUrlName = contractUrlName;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getContractState() {
        return contractState;
    }

    public void setContractState(Integer contractState) {
        this.contractState = contractState;
    }
}
