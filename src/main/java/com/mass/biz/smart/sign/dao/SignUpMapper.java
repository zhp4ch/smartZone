package com.mass.biz.smart.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.sign.model.SignUpModel;

/**
 * 打卡Dao类
 * 
 * @author vm3
 * 
 */
@Mapper
public interface SignUpMapper {

	// 打卡记录list查询
	List<SignUpModel> selectPageList(
			@Param("searchParams") SignUpModel signModel,
			@Param("offset") Integer offset, @Param("limit") Integer limit);

	// 打卡记录总数
	Long count(SignUpModel signModel);

	// 考勤详情
	List<SignUpModel> getUserDetail(
			@Param("searchParams") SignUpModel signModel,
			@Param("offset") Integer offset, @Param("limit") Integer limit);

	// 考勤详情总数
	Long detailCount(SignUpModel signModel);

	SignUpModel getSignByCode(@Param("id_code") String id_code,
			@Param("create_time") String create_time);
	
	int updateEntiy(SignUpModel signModel);
	
	// 按月统计考勤人数
	List<Object> selectMonthCount();
	// 查询每天考勤人数
	List<Object> selectDayCount(String date);
	
	void initSignData();
	
	/**
	 * 考勤导出
	 * @param signUpModel
	 * @return
	 */
	List<SignUpModel> exportForm(@Param("searchParams")SignUpModel signUpModel);
	
	/**
	 * 统计这个人员未打卡,迟到,早退的次数
	 * @param signUpModel
	 * @return
	 */
	List<SignUpModel> countState(@Param("searchParams")SignUpModel signUpModel);
}
