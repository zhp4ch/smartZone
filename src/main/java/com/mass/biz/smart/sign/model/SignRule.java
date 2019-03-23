package com.mass.biz.smart.sign.model;

/**
 * 打卡规则的实体类
 * @author computer
 *
 */
public class SignRule {

		private Long rid; //主键
		
		private Long merchantId;//商户id
		
		private String onTime;  //上班时间
		
		private String offTime; //下班时间
		
		private Integer state; //删除状态（0.否，1.是）
		
		private String remark; //备注
		
		private String createTime; //创建时间
		
		private String updateTime; //更新时间
		
		private String corporateName;//商户名称
		
		private Integer examineState;  //审核状态（初始化为0审核中，1已通过，2已驳回）
		
		private String idCode;   //身份证号码

		public Long getRid() {
			return rid;
		}

		public void setRid(Long rid) {
			this.rid = rid;
		}

		public Long getMerchantId() {
			return merchantId;
		}

		public void setMerchantId(Long merchantId) {
			this.merchantId = merchantId;
		}

		public String getOnTime() {
			return onTime;
		}

		public void setOnTime(String onTime) {
			this.onTime = onTime;
		}

		public String getOffTime() {
			return offTime;
		}

		public void setOffTime(String offTime) {
			this.offTime = offTime;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
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

		public String getIdCode() {
			return idCode;
		}

		public void setIdCode(String idCode) {
			this.idCode = idCode;
		}
		
		
}
