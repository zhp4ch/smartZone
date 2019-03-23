package com.mass.biz.smart.property.equipmentsInspection.service;

import java.util.List;

import com.mass.biz.smart.property.equipmentsInspection.model.InspectionModel;

public interface InspectionService {

	/**
	 * 
	 * @Title:selectinspectionList
	 * @Description:(分页条件查询)
	 * @return:List<InspectionModel>(返回类型)
	 * @author:hq
	 * @throws
	 */
	List<InspectionModel> selectinspectionList(InspectionModel inspectionModel,
			Integer pageIndex, Integer pageSize);

	// 总数配合分页
	Long count(InspectionModel inspectionModel);

	/**
	 * 
	 * @Title:updateInspection
	 * @Description:(修改处理状态dealWith)
	 * @return:Integer(返回类型)
	 * @author:hq
	 * @throws
	 */
	Integer updateInspection(InspectionModel inspectionModel);

	// 分页查询所有工作人员
	List<InspectionModel> selectUserList(InspectionModel inspectionModel, int pageIndex,
			Integer pageSize);

	Long userCount(InspectionModel inspectionModel);

	// 新增派工数据
	void addMendUser(InspectionModel inspectionModel);
	
	List<InspectionModel> selectInsByYear(String year);
	
	List<InspectionModel> selectInsByEqu(String year);
	
	InspectionModel addInspection(InspectionModel inspectionModel);
	
	//根据id查询
	InspectionModel selectInspectionById(Long id);
	
	
	//我的处理查询
	List<InspectionModel> selectDisposeByUserIdWx(Long userId,Integer pageIndex,Integer pageSize);
	
	//设备巡检id查询该设备的派工人员
	List<InspectionModel>   selectPropertymendUser(Long id);
}
