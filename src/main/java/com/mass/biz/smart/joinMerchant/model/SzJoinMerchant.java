package com.mass.biz.smart.joinMerchant.model;

/**
 * 申请加入企业
 * sz_join_merchant
 * @author jiangd
 */
public class SzJoinMerchant {

	private Long rid;
	//申请人
	private Long user_id;
	//申请加入的企业
	private Long merchant_id;
	//审核状态：0-未审核，1-审核通过，2-驳回，3-撤销申请
	private Long state;
	//申请时间
	private String create_time;
	//审核时间
	private String examine_time;
	//备注
	private String remark;
	
	
	//申请加入的企业的负责人，即企业的申请入驻人sz_merchant.user_id
	private Long merchant_user_id;
	//申请加入的员工姓名
	private String empoyeeName;
	//申请加入的公司名称
	private String companeyName;
	//公司编码
	private String merchant_code;
	//申请人的联系电话
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}
	public String getEmpoyeeName() {
		return empoyeeName;
	}
	public void setEmpoyeeName(String empoyeeName) {
		this.empoyeeName = empoyeeName;
	}
	public String getCompaneyName() {
		return companeyName;
	}
	public void setCompaneyName(String companeyName) {
		this.companeyName = companeyName;
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
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getExamine_time() {
		return examine_time;
	}
	public void setExamine_time(String examine_time) {
		this.examine_time = examine_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getMerchant_user_id() {
		return merchant_user_id;
	}
	public void setMerchant_user_id(Long merchant_user_id) {
		this.merchant_user_id = merchant_user_id;
	}
	
	

}
