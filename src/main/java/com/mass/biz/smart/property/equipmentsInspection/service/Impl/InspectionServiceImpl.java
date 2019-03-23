package com.mass.biz.smart.property.equipmentsInspection.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.property.equipmentsInspection.dao.InspectionMapper;
import com.mass.biz.smart.property.equipmentsInspection.model.InspectionModel;
import com.mass.biz.smart.property.equipmentsInspection.service.InspectionService;

@Service
public class InspectionServiceImpl implements InspectionService {

	@Autowired
	private InspectionMapper inspectionMapper;
	
	@Override
	public List<InspectionModel> selectinspectionList(
			InspectionModel inspectionModel,Integer pageIndex,Integer pageSize) {
		return  inspectionMapper.selectPageList(inspectionModel, pageIndex, pageSize);
		
	}

	@Override
	public Long count(InspectionModel inspectionModel) {
		return  inspectionMapper.count(inspectionModel);
	}

	@Override
	public Integer updateInspection(InspectionModel inspectionModel) {
		
		Integer data= inspectionMapper.updateInspection(inspectionModel);//data 修改返回的参数
		if(data==1){
			return data;
		}else{
			return 0;
		}
		
	}
	@Override
	public List<InspectionModel> selectUserList(InspectionModel inspectionModel, int pageIndex,
			Integer pageSize) {
		List<InspectionModel> list = this.inspectionMapper.selectUserList(inspectionModel, pageIndex, pageSize);
		return list;
	}

	@Override
	public Long userCount(InspectionModel inspectionModel) {
		return this.inspectionMapper.userCount(inspectionModel);
	}
	
	@Override
	public void addMendUser(InspectionModel inspectionModel) {
		this.inspectionMapper.addMendUser(inspectionModel);
		if(inspectionModel.getDealWith()==1){
			inspectionModel.setDealWith(2);
			inspectionMapper.updateInspection(inspectionModel);//data 修改返回的参数
			return;
		}if(inspectionModel.getDealWith()==2){
			inspectionModel.setDealWith(3);
			inspectionMapper.updateInspection(inspectionModel);//data 修改返回的参数
		}
		 
	}

	@Override
	public List<InspectionModel> selectInsByYear(String year) {
		List<InspectionModel> list = this.inspectionMapper.selectInsByYear(year);
		return list;
	}
	

	@Override
	public List<InspectionModel> selectInsByEqu(String year) {
		List<InspectionModel> list = this.inspectionMapper.selectInsByEqu(year);
		return list;
	}

	@Override
	public InspectionModel addInspection(InspectionModel inspectionModel) {
		int i = this.inspectionMapper.addInspection(inspectionModel);
		if(i>0){
			return inspectionModel;
		}else{
			return null;
		}
	}

	@Override
	public InspectionModel selectInspectionById(Long id) {
		return inspectionMapper.selectInspectionById(id);
		
		
	}

	@Override
	public List<InspectionModel> selectDisposeByUserIdWx(Long userId,Integer pageIndex,Integer pageSize) {
		return inspectionMapper.selectDisposeByUserIdWx(userId,pageIndex,pageSize);
	}

	/**
	 * 设备巡检id查询该设备的派工人员
	 */
	@Override
	public List<InspectionModel> selectPropertymendUser(Long id) {
		return inspectionMapper.selectPropertymendUser(id);
	}
}
