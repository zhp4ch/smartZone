package com.mass.biz.smart.property.propertyMend.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.property.propertyMend.dao.PropertyMendMapper;
import com.mass.biz.smart.property.propertyMend.model.PropertyMend;
import com.mass.biz.smart.property.propertyMend.service.PropertyMendService;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：PropertyMendServiceImpl
 * 类描述：物业报修实现层
 * 创建人：yihai Zhao
 * 创建时间：2018年8月6日 上午9:02:45
 * 修改人：yihai Zhao
 * 修改时间：2018年8月6日 上午9:02:45
 * 
 * @version
 *
 */
@Service
public class PropertyMendServiceImpl implements PropertyMendService {

	@Autowired
	private PropertyMendMapper propertyMendMapper;
	
	@Override
	public PropertyMend addPropertyMend(PropertyMend propertyMend) {
		return this.propertyMendMapper.addPropertyMend(propertyMend)>0?propertyMend:null;
	}

	@Override
	public boolean editPropertyMend(PropertyMend propertyMend) {
		return 0<this.propertyMendMapper.editPropertyMend(propertyMend);
	}

	@Override
	public boolean delPropertyMend(Long id) {
		return 0<this.propertyMendMapper.delPropertyMend(id);
	}

	@Override
	public PropertyMend getPropertyMendById(Long id) {
		return this.propertyMendMapper.getPropertyMendById(id);
	}

	@Override
	public List<PropertyMend> selectPageList(PropertyMend propertyMend,
			Integer pageIndex, Integer pageSize) {
		List<PropertyMend> list = this.propertyMendMapper.selectPageList(propertyMend, pageIndex, pageSize);
		return list;
	}

	@Override
	public Long count(PropertyMend propertyMend) {
		return this.propertyMendMapper.count(propertyMend);
	}

	@Override
	public List<PropertyMend> selectUserList(PropertyMend propertyMend,
			int pageIndex, Integer pageSize) {
		List<PropertyMend> list = this.propertyMendMapper.selectUserList(propertyMend, pageIndex, pageSize);
		return list;
	}

	@Override
	public Long userCount(PropertyMend propertyMend) {
		return this.propertyMendMapper.userCount(propertyMend);
	}

	@Override
	public void addMendUser(PropertyMend propertyMend) {
		 this.propertyMendMapper.addMendUser(propertyMend);
	}

	@Override
	public List<PropertyMend> selectMendStart(PropertyMend propertyMend) {
		List<PropertyMend> list = this.propertyMendMapper.selectMendStart(propertyMend);
		return list;
	}

	@Override
	public List<PropertyMend> selectMendEnd(PropertyMend propertyMend) {
		List<PropertyMend> list = this.propertyMendMapper.selectMendEnd(propertyMend);
		return list;
	}

	@Override
	public List<PropertyMend> selectAdminMendStart(PropertyMend propertyMend) {
		List<PropertyMend> list = this.propertyMendMapper.selectAdminMendStart(propertyMend);
		return list;
	}

	@Override
	public List<PropertyMend> selectAdminMendEnd(PropertyMend propertyMend) {
		List<PropertyMend> list = this.propertyMendMapper.selectAdminMendEnd(propertyMend);
		return list;
	}

	@Override
	public List<PropertyMend> getPropertyMendByRid(Long rid) {
		List<PropertyMend> mend = this.propertyMendMapper.getPropertyMendByRid(rid);
		return mend;
	}
}
