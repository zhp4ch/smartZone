package com.mass.biz.smart.user.model;

import java.io.Serializable;

/**
 * 微信端用户 sz_user
 * 
 * @author jiangd
 */
public class SzUser implements Serializable {
	
	
	public final static Integer TYPE_1 = 1;
	public final static Integer TYPE_2 = 2;
	public final static Integer TYPE_3 = 3;
	public final static Integer TYPE_4 = 4;

	/**
	 * jiangjiang 2018年7月17日
	 */
	private static final long serialVersionUID = 1L;
	private long rid;
	// 用户名称
	private String name;
	// 身份证号
	private String id_code;
	// 用户昵称
	private String nickname;
	// 联系电话
	private String phone;
	// sz_merchant中的字段,关联表查询中使用
	private String corporateName;
	//20180821--用户类型：1-普通职工，2-商户负责人，10-物业管理人员，11.物业执行人员 99-系统管理人员
	private Integer type;
	// 所属商户ID
	private Long merchant_id;
	// 是否删除：0-否，1-是
	private Integer is_delete;
	// 头像（路径）
	private String head_image;
	private String create_time;
	private String update_time;
	private String open_id;
	// 证件照路径
	private String id_image;
	// 所属商户CODE
	private String merchant_code;
	//人脸照片路径-yj
	private String img_path;
	
	//opid,在企业微信中这个才是真正的opid
	private String opid;
	
	public String getOpid() {
		return opid;
	}

	public void setOpid(String opid) {
		this.opid = opid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getId_image() {
		return id_image;
	}

	public void setId_image(String id_image) {
		this.id_image = id_image;
	}

	public String getOpen_id() {
		return open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_code() {
		return id_code;
	}

	public void setId_code(String id_code) {
		this.id_code = id_code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(Long merchant_id) {
		this.merchant_id = merchant_id;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	public String getHead_image() {
		return head_image;
	}

	public void setHead_image(String head_image) {
		this.head_image = head_image;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMerchant_code() {
		return merchant_code;
	}

	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

}
