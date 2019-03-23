package com.mass.biz.smart.merchant.model;


import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 商户入驻
 * @Author 郑上进
 * @Date 2018/7/17 11:14
 * @Version 1.0
 **/
public class SzMerchant implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 申请人/用户id
     */
    private Long userId;

    /**
     * 申请人/用户姓名
     */
    private String userName;

    /**
     * 法定代表人
     */
    private String representativeName;

    /**
     * 公司名称
     */
    private String corporateName;

    /**
     * 公司简称
     */
    private String abbreviation;

    /**
     * 公司地址
     */
    private String corporateAddress;

    /**
     * 公司门牌号
     */
    private String doorNumber;

    /**
     * 审核人id
     */
    private Long examineId;

    /**
     * 审核人姓名
     */
    private String examineName;

    /**
     * 审核状态（初始化为 0审核中，1已通过，2已驳回）
     */
    private Integer examineState;

    /**
     * 商户状态(0 禁用，1正常)
     */
    private Integer merchantState;

    /**
     * 审核意见
     */
    private String examineContent;

    /**
     * 流程图片路径
     */
    private String flowPictureUrl;

    /**
     * 企业资质图片路径
     */
    private String aptitudePictureUrl;

    /**
     * 租赁合同
     */
    private String contractPictureUrl;

    /**
     * 物业缴费票据图片路径
     */
    private String payPictureUrl;

    /**
     * 所属园区
     */
    private String park;

    /**
     * 文件信息id
     */
    private Long fileInfoId;

    /**
     * 数据创建时间
     */
    private Date createTime;

    /**
     * 删除状态id
     */
    private Integer delFlag;

    /**
     * 审核通过时间
     */
    private String examineOkTime;
    
    //GZ+时间戳，作为公司唯一编码
    private String merchant_code;
    
    //楼栋编号
    private String building_number;

    public Integer getMerchantState() {
        return merchantState;
    }

    public void setMerchantState(Integer merchantState) {
        this.merchantState = merchantState;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCorporateAddress() {
        return corporateAddress;
    }

    public void setCorporateAddress(String corporateAddress) {
        this.corporateAddress = corporateAddress;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getExamineOkTime() {
        return examineOkTime;
    }

    public void setExamineOkTime(String examineOkTime) {
        this.examineOkTime = examineOkTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getExamineId() {
        return examineId;
    }

    public void setExamineId(Long examineId) {
        this.examineId = examineId;
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

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public Integer getExamineState() {
        return examineState;
    }

    public void setExamineState(Integer examineState) {
        this.examineState = examineState;
    }

    public String getFlowPictureUrl() {
        return flowPictureUrl;
    }

    public void setFlowPictureUrl(String flowPictureUrl) {
        this.flowPictureUrl = flowPictureUrl;
    }

    public String getContractPictureUrl() {
        return contractPictureUrl;
    }

    public void setContractPictureUrl(String contractPictureUrl) {
        this.contractPictureUrl = contractPictureUrl;
    }

    public String getAptitudePictureUrl() {
        return aptitudePictureUrl;
    }

    public void setAptitudePictureUrl(String aptitudePictureUrl) {
        this.aptitudePictureUrl = aptitudePictureUrl;
    }

    public String getPayPictureUrl() {
        return payPictureUrl;
    }

    public void setPayPictureUrl(String payPictureUrl) {
        this.payPictureUrl = payPictureUrl;
    }

    public String getExamineContent() {
        return examineContent;
    }

    public void setExamineContent(String examineContent) {
        this.examineContent = examineContent;
    }

    public Long getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(Long fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExamineName() {
        return examineName;
    }

    public void setExamineName(String examineName) {
        this.examineName = examineName;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

	public String getMerchant_code() {
		return merchant_code;
	}

	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}

	public String getBuilding_number() {
		return building_number;
	}

	public void setBuilding_number(String building_number) {
		this.building_number = building_number;
	}
    
    
}
