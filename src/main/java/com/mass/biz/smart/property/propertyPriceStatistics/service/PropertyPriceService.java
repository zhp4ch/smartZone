package com.mass.biz.smart.property.propertyPriceStatistics.service; 

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.property.propertyPriceStatistics.model.PropertyPrice;

/**
*
* 类名称：PropertyPriceService
* 类描述：物业统计
* 创建人：zx
* 创建时间：2018‎年‎8‎月‎8‎日 10:14:05
* 
* @version
*
*/
public interface PropertyPriceService {

		//新增
		PropertyPrice addPropertyPrice(PropertyPrice propertyPrice);
		
		//修改
		boolean editPropertyPrice(PropertyPrice propertyPrice);
		
		//删除
		boolean delPropertyPrice(@Param("id")Long id);
		
		//详情
		PropertyPrice getPropertyPriceById(@Param("id")Long id);
		
		//分页查询
		List<PropertyPrice> selectPageList(PropertyPrice propertyPrice,Integer pageIndex,Integer pageSize);
		//总数配合分页
		Long count(PropertyPrice propertyPrice);
		//查询当月未创建账单人员信息
		List<PropertyPrice> queryUserByCreateTime();
		//本月各户总费用统计
		List<PropertyPrice> queryTotalByMonth(String payDate);
		//按年统计每个月收款总额
		List<PropertyPrice> queryAllTotalByYear(String payDate);
		//根据身份证查询userId
		PropertyPrice getByIdCode(String idCode);
		//根据userid查询数量
		Long getCountByUserId(PropertyPrice pp);
		//用户物业费详情
		List<PropertyPrice> getPropertyPriceByUserId(Long userId);
		//根据用户id查询商户信息
		List<PropertyPrice> getMerchantByUserId(Long userId);
		//根据用户id查询应缴费时间前三天的数据
		List<PropertyPrice> queryPriceCountByuserId(Long userId);
}
