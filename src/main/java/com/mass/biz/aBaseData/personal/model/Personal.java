package com.mass.biz.aBaseData.personal.model;

import java.util.Date;

/**
 * 人员基础信息实体类
 * created by pannan on 2017/10/07
 * 
 */
public class Personal{
	private Long id;                //主键id
    private String employyeeCode;   //职工编号唯一
    private String name;            //姓名
    private String brforeName;      //曾用名
    private String idcard;          //身份证号
    private Integer sex;            //性别 0 = 男 1 = 女
    private String photoUrl;        //照片路径
    private String birthdate;       //出生日期
    private String nation;          //民族(字典表外键)
    private String nationDesc;      //民族
    private String modelWorkerType; //劳模类型(字典表外键)
    private String modelWorkerDesc; //劳模类型
    private String political;       //政治面貌(字典表外建)
    private String politicalDesc;   //政治面貌
    private String positions;       //职务
    private String positionalTitle; //职称
    private String insuredStatus;   //参保状态
    private String profSkill;       //专业技能
    private String craft;       	   //工种
    private Integer isSocialInsurance; //有无社保 1=有   0=无
    private Integer isMedicalInsurance; //有无医保 1=有   0=无
    private String healthStatus;    //健康状况(字典表外键)
    private String healthDesc;      //健康状况
    private String disabilityType;  //疾病/残疾类别(字典表外键)
    private String disabilityDesc;  //疾病/残疾类别
    private String marriageStatus;  //婚姻状况(字典表外键)
    private String marriageDesc;    //婚姻状况
    private String identity; 	   //人员身份(字典表外键)
    private String identityDesc;   //人员身份
    private String school;         //学校
    private String education;      //当前学历（字典表外键）[最高学历]
    private String educationDesc;  //当前学历
    private String enrollmentTime; //入学年份
    private String laborOrJoinTime;//劳动合同签订/入伍时间
    private String laborDueTime;   //合同期限(字典表外键)
    private String laborDueTimeDesc;//合同期限
    private String workStatus;     //工作状态（字典表外键）
    private String workDesc;       //工作状态
    private String workTime;       //参加工作时间
    private String homeType;       //住房类型(字典表外键)
    private String homeDesc;       //住房类型
    private String homeArea;       //房屋建筑面积（字典表外键）
    private String homeAreaDesc;   //房屋建筑面积
    private String homeAddress;    //家庭住址
    private Integer isSingleParent;//是否单亲 1=是  0=否
    private String otherPhone;     //其他电话
    private String mobilePhone;    //移动电话
    private String belongIndustries;//所属行业(字典表外键)
    private String belongIndustriesDesc;//所属行业
    private String description;  	//个人荣誉()
    private String registerType;     //户口类型（字典表外键）
    private String registerDesc;     //户口类型
    private String registerRegion;     //户口所在地(地区表)
    private String myMonthIncome;    //本人平均月收入
    private Integer isModel;       //是否是劳模（1=是，0=否）
    private Integer isDifficult;       //是否困难职工（1=是，0=否）
    private Integer isJobless;       //是否为零就业家庭(1=是，0=否)
    private Long unionId;            //所属公会（工会表外键）
    private String unionName;      //所属公会
    private Long unitId;             //单位id(新增时使用)
    private String unitName;         //单位名称(新增时使用)
    private Long parentId;           //父级id
    private Integer flag;            //状态标识
    private Long lastOperatorId;			//最后操作人ID，关联T_SYS_USER表
    private Date updateTime;       //更新时间
    
    private String province;//（省-查询使用[同所在单位]）
    private String city; //（市-查询使用）
    private String county; //（区县-查询使用）
	
    public Long getId() {
		return id;
	}
	public String getEmployyeeCode() {
		return employyeeCode;
	}
	public String getName() {
		return name;
	}
	public String getBrforeName() {
		return brforeName;
	}
	public String getIdcard() {
		return idcard;
	}
	public Integer getSex() {
		return sex;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getNation() {
		return nation;
	}
	public String getNationDesc() {
		return nationDesc;
	}
	public String getModelWorkerType() {
		return modelWorkerType;
	}
	public String getModelWorkerDesc() {
		return modelWorkerDesc;
	}
	public String getPolitical() {
		return political;
	}
	public String getPoliticalDesc() {
		return politicalDesc;
	}
	public String getPositions() {
		return positions;
	}
	public String getPositionalTitle() {
		return positionalTitle;
	}
	public String getInsuredStatus() {
		return insuredStatus;
	}
	public String getProfSkill() {
		return profSkill;
	}
	public String getCraft() {
		return craft;
	}
	public Integer getIsSocialInsurance() {
		return isSocialInsurance;
	}
	public Integer getIsMedicalInsurance() {
		return isMedicalInsurance;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public String getHealthDesc() {
		return healthDesc;
	}
	public String getDisabilityType() {
		return disabilityType;
	}
	public String getDisabilityDesc() {
		return disabilityDesc;
	}
	public String getMarriageStatus() {
		return marriageStatus;
	}
	public String getMarriageDesc() {
		return marriageDesc;
	}
	public String getIdentity() {
		return identity;
	}
	public String getIdentityDesc() {
		return identityDesc;
	}
	public String getSchool() {
		return school;
	}
	public String getEducation() {
		return education;
	}
	public String getEducationDesc() {
		return educationDesc;
	}
	public String getEnrollmentTime() {
		return enrollmentTime;
	}
	public String getLaborOrJoinTime() {
		return laborOrJoinTime;
	}
	public String getLaborDueTime() {
		return laborDueTime;
	}
	public String getLaborDueTimeDesc() {
		return laborDueTimeDesc;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public String getWorkDesc() {
		return workDesc;
	}
	public String getWorkTime() {
		return workTime;
	}
	public String getHomeType() {
		return homeType;
	}
	public String getHomeDesc() {
		return homeDesc;
	}
	public String getHomeArea() {
		return homeArea;
	}
	public String getHomeAreaDesc() {
		return homeAreaDesc;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public Integer getIsSingleParent() {
		return isSingleParent;
	}
	public String getOtherPhone() {
		return otherPhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public String getBelongIndustries() {
		return belongIndustries;
	}
	public String getBelongIndustriesDesc() {
		return belongIndustriesDesc;
	}
	public String getDescription() {
		return description;
	}
	public String getRegisterType() {
		return registerType;
	}
	public String getRegisterDesc() {
		return registerDesc;
	}
	public String getRegisterRegion() {
		return registerRegion;
	}
	public String getMyMonthIncome() {
		return myMonthIncome;
	}
	public Integer getIsModel() {
		return isModel;
	}
	public Integer getIsDifficult() {
		return isDifficult;
	}
	public Integer getIsJobless() {
		return isJobless;
	}
	public Long getUnionId() {
		return unionId;
	}
	public String getUnionName() {
		return unionName;
	}
	public Long getUnitId() {
		return unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public Long getParentId() {
		return parentId;
	}
	public Integer getFlag() {
		return flag;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEmployyeeCode(String employyeeCode) {
		this.employyeeCode = employyeeCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrforeName(String brforeName) {
		this.brforeName = brforeName;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public void setNationDesc(String nationDesc) {
		this.nationDesc = nationDesc;
	}
	public void setModelWorkerType(String modelWorkerType) {
		this.modelWorkerType = modelWorkerType;
	}
	public void setModelWorkerDesc(String modelWorkerDesc) {
		this.modelWorkerDesc = modelWorkerDesc;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public void setPoliticalDesc(String politicalDesc) {
		this.politicalDesc = politicalDesc;
	}
	public void setPositions(String positions) {
		this.positions = positions;
	}
	public void setPositionalTitle(String positionalTitle) {
		this.positionalTitle = positionalTitle;
	}
	public void setInsuredStatus(String insuredStatus) {
		this.insuredStatus = insuredStatus;
	}
	public void setProfSkill(String profSkill) {
		this.profSkill = profSkill;
	}
	public void setCraft(String craft) {
		this.craft = craft;
	}
	public void setIsSocialInsurance(Integer isSocialInsurance) {
		this.isSocialInsurance = isSocialInsurance;
	}
	public void setIsMedicalInsurance(Integer isMedicalInsurance) {
		this.isMedicalInsurance = isMedicalInsurance;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public void setHealthDesc(String healthDesc) {
		this.healthDesc = healthDesc;
	}
	public void setDisabilityType(String disabilityType) {
		this.disabilityType = disabilityType;
	}
	public void setDisabilityDesc(String disabilityDesc) {
		this.disabilityDesc = disabilityDesc;
	}
	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	public void setMarriageDesc(String marriageDesc) {
		this.marriageDesc = marriageDesc;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public void setIdentityDesc(String identityDesc) {
		this.identityDesc = identityDesc;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public void setEducationDesc(String educationDesc) {
		this.educationDesc = educationDesc;
	}
	public void setEnrollmentTime(String enrollmentTime) {
		this.enrollmentTime = enrollmentTime;
	}
	public void setLaborOrJoinTime(String laborOrJoinTime) {
		this.laborOrJoinTime = laborOrJoinTime;
	}
	public void setLaborDueTime(String laborDueTime) {
		this.laborDueTime = laborDueTime;
	}
	public void setLaborDueTimeDesc(String laborDueTimeDesc) {
		this.laborDueTimeDesc = laborDueTimeDesc;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}
	public void setHomeDesc(String homeDesc) {
		this.homeDesc = homeDesc;
	}
	public void setHomeArea(String homeArea) {
		this.homeArea = homeArea;
	}
	public void setHomeAreaDesc(String homeAreaDesc) {
		this.homeAreaDesc = homeAreaDesc;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public void setIsSingleParent(Integer isSingleParent) {
		this.isSingleParent = isSingleParent;
	}
	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public void setBelongIndustries(String belongIndustries) {
		this.belongIndustries = belongIndustries;
	}
	public void setBelongIndustriesDesc(String belongIndustriesDesc) {
		this.belongIndustriesDesc = belongIndustriesDesc;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	public void setRegisterDesc(String registerDesc) {
		this.registerDesc = registerDesc;
	}
	public void setRegisterRegion(String registerRegion) {
		this.registerRegion = registerRegion;
	}
	public void setMyMonthIncome(String myMonthIncome) {
		this.myMonthIncome = myMonthIncome;
	}
	public void setIsModel(Integer isModel) {
		this.isModel = isModel;
	}
	public void setIsDifficult(Integer isDifficult) {
		this.isDifficult = isDifficult;
	}
	public void setIsJobless(Integer isJobless) {
		this.isJobless = isJobless;
	}
	public void setUnionId(Long unionId) {
		this.unionId = unionId;
	}
	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getCounty() {
		return county;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public Long getLastOperatorId() {
		return lastOperatorId;
	}
	public void setLastOperatorId(Long lastOperatorId) {
		this.lastOperatorId = lastOperatorId;
	}
}
