package com.mass.biz.smart.merchantScore.model;


/**
 * 商户积分 sz_merchant_score
 * @author jiangd
 */
public class SzMerchantScore {
	
	/**
	 * 1.入驻

		首次入驻园区成功获奖励100积分
		
		2.投诉建议
		
		投诉建议被采纳一次奖励30积分，无上限
		
		3.报修反馈
		
		报修反馈及时奖励10积分，否则超过3天即视为反 馈延迟，扣取10积分
		
		4.员工加入
		
		每加入一个员工，奖励10积分
		
		5.圈子
		
		每发布一个话题加1分，每增加一条评论加1分
	 */
	
	//------------分值类型-----------
	//入驻T=10
	public static final int MERCAHNT_ENTER_TYPE = 10;
	//投诉建议T=20
	public static final int SUGGESTION_TYPE = 20;
	//报修反馈：及时T=30
	public static final int REPAIR_FEEDBACK_TIMELY_Y_TYPE = 30;
	//报修反馈:不及时T=31
	public static final int REPAIR_FEEDBACK_TIMELY_N_TYPE = 31;
	//员工加入T=40
	public static final int USER_ENTER_TYPE = 40;
	//圈子(发布话题加一分)T=50
	public static final int TOPIC_PUBLISH_TYPE = 50;
	//圈子(发布的话题被评论加一分)T=51
	public static final int TOPIC_ARGUED_TYPE = 51;
	
	//------------分值-----------
	//入驻T=10
	public static final Long MERCAHNT_ENTER_SCORE = 100L;
	//投诉建议T=SUGGESTION_TYPE
	private static final Long SUGGESTION_SCORE = 30L;
	//报修反馈：及时T=REPAIR_FEEDBACK_TIMELY_Y_TYPE
	private static final Long REPAIR_FEEDBACK_TIMELY_Y_SCORE = 10L;
	//报修反馈T=REPAIR_FEEDBACK_TIMELY_N_TYPE
	private static final Long REPAIR_FEEDBACK_TIMELY_N_SCORE = -10L;
	//员工加入T=USER_ENTER_TYPE
	private static final Long USER_ENTER_SCORE = 10L;
	//圈子(发布话题加一分)T=TOPIC_PUBLISH_TYPE
	private static final Long TOPIC_PUBLISH_SCORE = 1L;
	//圈子(发布的话题被评论加一分)T=51
	private static final Long TOPIC_ARGUED_SCORE = 1L;

	//-----------分值描述---------------
	//入驻
	public static final String MERCAHNT_ENTER_DESC = "首次入驻园区成功获奖励100积分";
	//投诉建议
	private static final String SUGGESTION_DESC = "投诉建议被采纳一次奖励30积分";
	//报修反馈:及时
	private static final String REPAIR_FEEDBACK_TIMELY_Y_DESC = "修反馈及时奖励10积分";
	//报修反馈:不及时
	private static final String REPAIR_FEEDBACK_TIMELY_N_DESC = "报修反馈超过3天即视为反馈延迟，扣取10积分";
	//员工加入
	private static final String USER_ENTER_DESC = "每加入一个员工，奖励10积分";
	//圈子(发布话题或者被评论的一分)
	private static final String TOPIC_PUBLISH_DESC = "每发布一个话题加1分";
	//圈子(被评论的一分)
	private static final String TOPIC_ARGUED_DESC = "每增加一条评论，给发布话题的人加1分";
	

	private Long rid;
	//商户ID
	private Long merchant_id;
	//当前分值
	private Long score;
	//描述
	private String description;
	//增减分值
	private Long changes;
	//是否删除：0-否，1-是
	private Long del_flag;
	//
	private String create_time;
	
	//商家名称
	private String corporate_name;
	
	//上次分数
	private Long last_sore;
	
	//积分贡献人ID
	private Long user_id;
	
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(Long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getChanges() {
		return changes;
	}
	public void setChanges(Long changes) {
		this.changes = changes;
	}
	public Long getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Long del_flag) {
		this.del_flag = del_flag;
	}
	public String getCorporate_name() {
		return corporate_name;
	}
	public void setCorporate_name(String corporate_name) {
		this.corporate_name = corporate_name;
	}
	public Long getLast_sore() {
		return last_sore;
	}
	public void setLast_sore(Long last_sore) {
		this.last_sore = last_sore;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	//根据积分类型，查询对应积分
	public static Long getScoreByType(int type){
		Long score = null;
		switch(type){
			case MERCAHNT_ENTER_TYPE:
				score = MERCAHNT_ENTER_SCORE;
			    break;
			case SUGGESTION_TYPE:
				score = SUGGESTION_SCORE;
			    break;
			case REPAIR_FEEDBACK_TIMELY_Y_TYPE:
				score = REPAIR_FEEDBACK_TIMELY_Y_SCORE;
			    break;
			case REPAIR_FEEDBACK_TIMELY_N_TYPE:
				score = REPAIR_FEEDBACK_TIMELY_N_SCORE;
			    break;
			case USER_ENTER_TYPE:
				score = USER_ENTER_SCORE;
			    break;
			case TOPIC_PUBLISH_TYPE:
				score = TOPIC_PUBLISH_SCORE;
			    break;
			case TOPIC_ARGUED_TYPE:
				score = TOPIC_ARGUED_SCORE;
			    break;
		}
		return score;
	}
	
	
	//根据积分类型，查询对应积分描述
	public static String getDescByType(int type){
		String desc = null;
		switch(type){
			case MERCAHNT_ENTER_TYPE:
				desc = MERCAHNT_ENTER_DESC;
			    break;
			case SUGGESTION_TYPE:
				desc = SUGGESTION_DESC;
			    break;
			case REPAIR_FEEDBACK_TIMELY_Y_TYPE:
				desc = REPAIR_FEEDBACK_TIMELY_Y_DESC;
			    break;
			case REPAIR_FEEDBACK_TIMELY_N_TYPE:
				desc = REPAIR_FEEDBACK_TIMELY_N_DESC;
			    break;
			case USER_ENTER_TYPE:
				desc = USER_ENTER_DESC;
			    break;
			case TOPIC_PUBLISH_TYPE:
				desc = TOPIC_PUBLISH_DESC;
			    break;
			case TOPIC_ARGUED_TYPE:
				desc = TOPIC_ARGUED_DESC;
			    break;
		}
		return desc;
	}

}
