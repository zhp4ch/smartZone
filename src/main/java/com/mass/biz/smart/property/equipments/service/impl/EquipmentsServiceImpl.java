package com.mass.biz.smart.property.equipments.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;



import com.mass.biz.smart.property.equipments.dao.EquipmentsMapper;
import com.mass.biz.smart.property.equipments.model.Equipments;
import com.mass.biz.smart.property.equipments.model.EquipmentsExample;
import com.mass.biz.smart.property.equipments.service.EquipmentsService;
import com.mass.core.utils.AjaxResponse;

@Service
public class EquipmentsServiceImpl implements EquipmentsService {

	@Autowired
	private EquipmentsMapper equipmentsMapper;

	@Override
	public AjaxResponse selectPageList(Equipments equipments,
			Integer pageIndex, Integer pageSize) {
		EquipmentsExample equipmentsExample = new EquipmentsExample();
		EquipmentsExample.Criteria criteria = equipmentsExample
				.createCriteria();
		// 分页
		equipmentsExample.setPageIndex((pageIndex - 1) * pageSize);
		equipmentsExample.setPageSize(pageSize);
		criteria.andDelFlagEqualTo((byte) 0);
		// 判断是否条件查询
		if (!ObjectUtils.isEmpty(equipments)) {
			if (!ObjectUtils.isEmpty(equipments.getDeviceNo())) {
				criteria.andDeviceNoEqualTo(equipments.getDeviceNo());
			}
			if (!ObjectUtils.isEmpty(equipments.getcDeviceName())) {
				criteria.andCDeviceNameLike("%"+equipments.getcDeviceName()+"%");
			}
			if (!ObjectUtils.isEmpty(equipments.getDeviceState())) {
				criteria.andDeviceStateEqualTo(equipments.getDeviceState());
			}
			if (!ObjectUtils.isEmpty(equipments.getDeviceType())) {
				criteria.andDeviceTypeEqualTo(equipments.getDeviceType());
			}
			if (!ObjectUtils.isEmpty(equipments.getFactoryTime())) {
				criteria.andFactoryTimeLike(equipments.getFactoryTime()+"%");
			}
			if (!ObjectUtils.isEmpty(equipments.getContact())) {
				criteria.andContactEqualTo(equipments.getContact());
			}
		}
		List<Equipments> equipmentsList = equipmentsMapper
				.selectByExample(equipmentsExample);
		long count = equipmentsMapper.countByExample(equipmentsExample);
		return AjaxResponse.success("ok", equipmentsList, count, pageIndex);
	}

	@Override
	public Integer insertEquipments(Equipments equipments) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		equipments.setCreateTime(df.format(new Date()));
		return equipmentsMapper.insertSelective(equipments);

	}

	@Override
	public Integer updatEquipments(Equipments equipments) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		equipments.setUpdateTime(df.format(new Date()));
		return equipmentsMapper.updateByPrimaryKeySelective(equipments);
	}

	@Override
	public Integer delectEquipments(Long rid) {
		Equipments equipments =new Equipments();
		equipments.setRid(rid);
		equipments.setDelFlag((byte)1);
		return equipmentsMapper.updateByPrimaryKeySelective(equipments);
	}

	@Override
	public List<Equipments> selectByDeviceNo(String deviceNo) {
		EquipmentsExample equipmentsExample = new EquipmentsExample();
		EquipmentsExample.Criteria criteria = equipmentsExample
				.createCriteria();
		criteria.andDelFlagEqualTo((byte) 0);
		criteria.andDeviceNoEqualTo(deviceNo);
		return	equipmentsMapper.selectByExample(equipmentsExample);
		
	}
	
	//批量插入  by lgq 2018.8/17
    public int BatchInsert(List<Equipments> equipments)
    {
    	return equipmentsMapper.batchInsert(equipments);
    }

	@Override
	public Equipments selectByPrimaryKey(Long id) {
		Equipments equipments =equipmentsMapper.selectByPrimaryKey(id);
		return equipments;
	}

    
    
}
