package com.mass.biz.smart.sign.model;

import com.mass.biz.smart.user.model.SzUser;

/**
 * 考勤签到实体类
 * @author vm3
 *
 */
public class SignUpModel {

	private Long rid;
	
	private Long user_id;	//用户ID

	private Long merchant_id;	//所属商户ID
	
	private String name;	//姓名
	
	private String corporate_name;	//商户名称

	private String on_time;	//上班打卡时间

	private Integer on_state;	//上班打卡状态

	private String off_time;	//下班打卡时间

	private Integer off_state;	//下班打卡状态

	private String create_time;	//创建时间

	private String update_time;	//更新时间

	private String remark;	//备注
	
	private SzUser szUser;	//用户实体
	
	private String timeBefore;	//查询开始时间
	
	private String timeAfter;	//查询结束时间
	
	private String id_image;	//证件照
	
	private Integer onHitCode; //上班未打卡
	
	private Integer late; //迟到
	
	private Integer offHitCode;  //下班未打卡
	
	private Integer leava;  //早退

	public Integer getOnHitCode() {
		return onHitCode;
	}

	public void setOnHitCode(Integer onHitCode) {
		this.onHitCode = onHitCode;
	}

	public Integer getLate() {
		return late;
	}

	public void setLate(Integer late) {
		this.late = late;
	}

	public Integer getOffHitCode() {
		return offHitCode;
	}

	public void setOffHitCode(Integer offHitCode) {
		this.offHitCode = offHitCode;
	}

	public Integer getLeava() {
		return leava;
	}

	public void setLeava(Integer leava) {
		this.leava = leava;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(Long merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getOn_time() {
		return on_time;
	}

	public void setOn_time(String on_time) {
		this.on_time = on_time;
	}

	public Integer getOn_state() {
		return on_state;
	}

	public void setOn_state(Integer on_state) {
		this.on_state = on_state;
	}

	public String getOff_time() {
		return off_time;
	}

	public void setOff_time(String off_time) {
		this.off_time = off_time;
	}

	public Integer getOff_state() {
		return off_state;
	}

	public void setOff_state(Integer off_state) {
		this.off_state = off_state;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorporate_name() {
		return corporate_name;
	}

	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}

	public SzUser getSzUser() {
		return szUser;
	}

	public void setSzUser(SzUser szUser) {
		this.szUser = szUser;
	}

	public String getTimeBefore() {
		return timeBefore;
	}

	public void setTimeBefore(String timeBefore) {
		this.timeBefore = timeBefore;
	}

	public String getTimeAfter() {
		return timeAfter;
	}

	public void setTimeAfter(String timeAfter) {
		this.timeAfter = timeAfter;
	}

	public String getId_image() {
		return id_image;
	}

	public void setId_image(String id_image) {
		this.id_image = id_image;
	}
	
}
