package com.mass.biz.smart.property.propertyMend.service; 

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.property.propertyMend.model.PropertyMend;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：PropertyMendService
 * 类描述：物业报修
 * 创建人：yihai Zhao
 * 创建时间：2018年8月6日 上午9:00:01
 * 修改人：yihai Zhao
 * 修改时间：2018年8月6日 上午9:00:01
 * 
 * @version
 *
 */
public interface PropertyMendService {

		//新增
		PropertyMend addPropertyMend(PropertyMend propertyMend);
		
		//修改	评价		确认完工	 反馈
		boolean editPropertyMend(PropertyMend propertyMend);
		
		//删除
		boolean delPropertyMend(@Param("id")Long id);
		
		//详情
		PropertyMend getPropertyMendById(@Param("id")Long id);
		
		//分页查询
		List<PropertyMend> selectPageList(PropertyMend propertyMend,Integer pageIndex,Integer pageSize);
		
		Long count(PropertyMend propertyMend);
		//分页查询所有工作人员 
		List<PropertyMend> selectUserList(PropertyMend propertyMend, int pageIndex,Integer pageSize);
		
		Long userCount(PropertyMend propertyMend);
		//新增派工数据
		void addMendUser(PropertyMend propertyMend);
		
		List<PropertyMend> selectMendStart(PropertyMend propertyMend);
		
		List<PropertyMend> selectMendEnd(PropertyMend propertyMend);
		
		List<PropertyMend> selectAdminMendStart(PropertyMend propertyMend);
		
		List<PropertyMend> selectAdminMendEnd(PropertyMend propertyMend);
		
		List<PropertyMend> getPropertyMendByRid(Long rid);
}
