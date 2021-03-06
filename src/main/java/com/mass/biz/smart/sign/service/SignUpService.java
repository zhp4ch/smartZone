package com.mass.biz.smart.sign.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.sign.model.SignUpModel;

/**
 * 考勤打卡借口类
 * 
 * @author vm3
 * 
 */
public interface SignUpService {

	// 打卡记录list查询
	List<SignUpModel> selectPageList(SignUpModel signModel, Integer offset,
			Integer limit);

	// 打卡记录总数
	Long count(SignUpModel signModel);

	// 考勤详情
	List<SignUpModel> getUserDetail(SignUpModel signModel, Integer offset,
			Integer limit);

	// 考勤详情总数
	Long detailCount(SignUpModel signModel);
	
	// 根据id_code和时间查询打卡记录
	SignUpModel getSignByCode(String id_code,String create_time);
	
	Integer updateEntiy(SignUpModel signModel);
	
	//按月统计考勤人数
	List<Object> selectMonthCount();
	//查询每天考勤人数
	List<Object> selectDayCount(String date);
	
	void initSignData();
	
	/**
	 * 考勤导出
	 * @param signUpModel
	 * @return
	 */
	List<SignUpModel> exportForm(SignUpModel signUpModel);
	
	/**
	 * 统计这个人员未打卡,迟到,早退的次数
	 * @param signUpModel
	 * @return
	 */
	List<SignUpModel> countState(SignUpModel signUpModel);
	
}
