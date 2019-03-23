package com.mass.biz.smart.property.equipments.service;

import java.util.List;


import com.mass.biz.smart.property.equipments.model.Equipments;
import com.mass.core.utils.AjaxResponse;

public interface EquipmentsService {

	
	/**
	 * 
	 * @Title:selectPageList
	 * @Description:(分页条件查询)
	 * @return:List<Equipments>(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	AjaxResponse selectPageList(Equipments equipments,Integer pageIndex,
			Integer pageSize);
	
	
	
	/**
	 * 
	 * @Title:insertEquipments
	 * @Description:(新增)
	 * @return:Integer(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	Integer insertEquipments(Equipments equipments);
	
	
	/**
	 * 
	 * @Title:updatEquipments
	 * @Description:(修改)
	 * @return:Integer(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	Integer updatEquipments(Equipments equipments);
	
	
	
	/**
	 * 
	 * @Title:delectEquipments
	 * @Description:(逻辑删除)
	 * @return:Integer(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	Integer delectEquipments(Long rid);
	
	
	/**
	 * 
	 * @Title:selectByDeviceNo
	 * @Description:(根据设备编号查询重名)
	 * @return:List<Equipments>(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	List<Equipments> selectByDeviceNo(String deviceNo);
	
	
	 int BatchInsert(List<Equipments> equipments);
	
	 Equipments selectByPrimaryKey(Long id);
}
