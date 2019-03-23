package com.mass.biz.smart.property.propertyPriceStatistics.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.property.propertyPriceStatistics.dao.PropertyPriceMapper;
import com.mass.biz.smart.property.propertyPriceStatistics.model.PropertyPrice;
import com.mass.biz.smart.property.propertyPriceStatistics.service.PropertyPriceService;

/**
*
* 类名称：PropertyPriceServiceImpl
* 类描述：物业统计
* 创建人：zx
* 创建时间：2018‎年‎8‎月‎8‎日 10:14:05
* 
* @version
*
*/
@Service
public class PropertyPriceServiceImpl implements PropertyPriceService {

	@Autowired
	private PropertyPriceMapper propertyPriceMapper;

	@Override
	public PropertyPrice addPropertyPrice(PropertyPrice propertyPrice) {
		return this.propertyPriceMapper.addPropertyPrice(propertyPrice)>0?propertyPrice:null;
	}

	@Override
	public boolean editPropertyPrice(PropertyPrice propertyPrice) {
		return 0<this.propertyPriceMapper.editPropertyPrice(propertyPrice);
	}

	@Override
	public boolean delPropertyPrice(Long id) {
		return 0<this.propertyPriceMapper.delPropertyPrice(id);
	}

	@Override
	public PropertyPrice getPropertyPriceById(Long id) {
		return this.propertyPriceMapper.getPropertyPriceById(id);
	}

	@Override
	public List<PropertyPrice> selectPageList(PropertyPrice propertyPrice,
			Integer pageIndex, Integer pageSize) {
		return this.propertyPriceMapper.selectPageList(propertyPrice, pageIndex, pageSize);
	}

	@Override
	public Long count(PropertyPrice propertyPrice) {
		return this.propertyPriceMapper.count(propertyPrice);
	}

	@Override
	public List<PropertyPrice> queryUserByCreateTime() {
		return this.propertyPriceMapper.queryUserByCreateTime();
	}
	
	@Override
	public List<PropertyPrice> queryTotalByMonth(String payDate) {
		return this.propertyPriceMapper.queryTotalByMonth(payDate);
	}
	
	@Override
	public List<PropertyPrice> queryAllTotalByYear(String payDate) {
		return this.propertyPriceMapper.queryAllTotalByYear(payDate);
	}

	@Override
	public PropertyPrice getByIdCode(String idCode) {
		return propertyPriceMapper.getByIdCode(idCode);
	}

	@Override
	public Long getCountByUserId(PropertyPrice pp) {
		return propertyPriceMapper.getCountByUserId(pp);
	}
	
	@Override
	public List<PropertyPrice> getPropertyPriceByUserId(Long id) {
		return propertyPriceMapper.getPropertyPriceByUserId(id);
	}

	@Override
	public List<PropertyPrice> getMerchantByUserId(Long userId) {
		List<PropertyPrice> list = propertyPriceMapper.getMerchantByUserId(userId);
		return list;
	}

	@Override
	public List<PropertyPrice> queryPriceCountByuserId(Long userId) {
		return  propertyPriceMapper.queryPriceCountByuserId(userId);
	}
}
