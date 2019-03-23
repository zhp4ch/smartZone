package com.mass.biz.smart.property.equipmentsInspection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.property.equipmentsInspection.model.InspectionModel;

@Mapper
public interface InspectionMapper {

	// 分页查询
	List<InspectionModel> selectPageList(
			@Param("inspectionModel") InspectionModel inspectionModel,
			@Param("pageIndex") Integer pageIndex,
			@Param("pageSize") Integer pageSize);

	// 总数配合分页
	Long count(InspectionModel inspectionModel);

	// 修改处理状态
	Integer updateInspection(InspectionModel inspectionModel);

	// 分页查询所有工作人员
	List<InspectionModel> selectUserList(@Param("inspectionModel") InspectionModel inspectionModel,
			@Param("pageIndex") Integer pageIndex,
			@Param("pageSize") Integer pageSize);

	long userCount(@Param("inspectionModel") InspectionModel inspectionModel);

	void addMendUser(InspectionModel inspectionModel);
	
	//按年统计每个月巡检次数
	List<InspectionModel> selectInsByYear(@Param("year")String year);

	//按设备统计一年巡检了多少次
	List<InspectionModel> selectInsByEqu(@Param("year")String year);
	
	//新增
	int addInspection(InspectionModel inspectionModel);
	
	//根基id查询
	InspectionModel selectInspectionById(@Param("id")Long year);
	
	//我的处理
	List<InspectionModel> selectDisposeByUserIdWx(@Param("userId")Long userId,@Param("pageIndex") Integer pageIndex,
			@Param("pageSize") Integer pageSize);
	
	//设备巡检id查询该设备的派工人员
	List<InspectionModel> selectPropertymendUser(@Param("id")Long id);
	
}
