package com.mass.biz.smart.property.propertyMend.dao; 

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.property.propertyMend.model.PropertyMend;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：propertyMendMapper
 * 类描述：物业报修dao
 * 创建人：yihai Zhao
 * 创建时间：2018年7月24日 上午11:29:17
 * 修改人：yihai Zhao
 * 修改时间：2018年7月24日 上午11:29:17
 * 
 * @version
 *
 */
@Mapper
public interface PropertyMendMapper {
	
	//新增
	int addPropertyMend(PropertyMend propertyMend);
	
	//修改	评价		确认完工	 反馈
	int editPropertyMend(PropertyMend propertyMend);
	
	//删除
	int delPropertyMend(@Param("id")Long id);
	
	//详情
	PropertyMend getPropertyMendById(@Param("id")Long id);
	
	//分页查询
	List<PropertyMend> selectPageList(@Param("propertyMend")PropertyMend propertyMend,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	
	long count(@Param("propertyMend")PropertyMend propertyMend);
	//减少商户积分

	
	//导出
	
	//派工处理
	
	//对工作人员推送消息
	
	//分页查询所有工作人员 
	List<PropertyMend> selectUserList(@Param("propertyMend")PropertyMend propertyMend,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);

	long userCount(@Param("propertyMend")PropertyMend propertyMend);

	void addMendUser(PropertyMend propertyMend);
	
	//wx查询
	List<PropertyMend> selectMendStart(PropertyMend propertyMend);
	
	List<PropertyMend> selectMendEnd(PropertyMend propertyMend);
	
	List<PropertyMend> selectAdminMendStart(PropertyMend propertyMend);
	
	List<PropertyMend> selectAdminMendEnd(PropertyMend propertyMend);
	
	List<PropertyMend> getPropertyMendByRid(@Param("rid")Long rid);
}
