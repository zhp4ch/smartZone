package com.mass.biz.smart.property.equipmentsInspection.model;

import com.mass.biz.smart.property.equipments.model.Equipments;

public class InspectionModel {

	//主键id
	private Long id;
	
	
	//用户id
	private long rid;
	
	//设备id
	private Long deviceId;
	
	//巡检状况 (设备状态  0 设备正常    1设备故障)
	private Integer checkState;
	
	//描述de
	private String checkContent;
	
	//巡检图片 
	private String checkPic;
	
	//巡检时间
	private String checkTime;
	
	//维护状态(0.无需维护  1.需维护  2.维护中  3.维护完成)
	private Integer dealWith;
	
	//引入Equipments实体
	private Equipments equipments; 
	
	private Integer delFlag;
	
	//联系人
	private String name;
	
	private String idCode;

	private String phone;
	
	private String msg;
	
	//统计传参
	private String year;
	
	private Integer count;
	
	private String month;
	
	private String checkTimeBefore;
	
	private String checkTimeAfter;
	
	private Integer dType;
	
	
	
	 //存储我的处理信息
	//创建时间
	private  String createTime;
	
	//用户id
	private Long userId;
	
	//巡检人
	private String inspectionName;
		
	//推送消息
	private String msgContent;
	
	//设备编号
	private String deviceNo;
	
	//设备中文名称
	private String cDeviceName;
	
	//设备id
	private Long equipmentId;

	//check表中的id
	private Long checkId;

	//人员信息的图片
	private String idImage;
	
	
	
	
	public String getIdImage() {
		return idImage;
	}

	public void setIdImage(String idImage) {
		this.idImage = idImage;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getInspectionName() {
		return inspectionName;
	}

	public void setInspectionName(String inspectionName) {
		this.inspectionName = inspectionName;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getcDeviceName() {
		return cDeviceName;
	}

	public void setcDeviceName(String cDeviceName) {
		this.cDeviceName = cDeviceName;
	}

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Long getCheckId() {
		return checkId;
	}

	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}

	public Integer getdType() {
		return dType;
	}

	public void setdType(Integer dType) {
		this.dType = dType;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCheckTimeBefore() {
		return checkTimeBefore;
	}

	public void setCheckTimeBefore(String checkTimeBefore) {
		this.checkTimeBefore = checkTimeBefore;
	}

	public String getCheckTimeAfter() {
		return checkTimeAfter;
	}

	public void setCheckTimeAfter(String checkTimeAfter) {
		this.checkTimeAfter = checkTimeAfter;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getDealWith() {
		return dealWith;
	}

	public void setDealWith(Integer dealWith) {
		this.dealWith = dealWith;
	}

	public Equipments getEquipments() {
		return equipments;
	}

	public void setEquipments(Equipments equipments) {
		this.equipments = equipments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getCheckState() {
		return checkState;
	}

	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}

	public String getCheckContent() {
		return checkContent;
	}

	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
	}

	public String getCheckPic() {
		return checkPic;
	}

	public void setCheckPic(String checkPic) {
		this.checkPic = checkPic;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
