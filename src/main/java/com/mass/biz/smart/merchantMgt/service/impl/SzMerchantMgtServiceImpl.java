package com.mass.biz.smart.merchantMgt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.merchantMgt.dao.SzMerchantMgtMapper;
import com.mass.biz.smart.merchantMgt.model.SzMerchantMgt;
import com.mass.biz.smart.merchantMgt.service.SzMerchantMgtService;

@Service
public class SzMerchantMgtServiceImpl implements SzMerchantMgtService {

	@Autowired
	SzMerchantMgtMapper szMerchantMgtMapper;

	@Override
	public int batchInsert(List<SzMerchantMgt> list) {
		return szMerchantMgtMapper.batchInsert(list);
	}

	@Override
	public int update(SzMerchantMgt szMerchantMgt) {
		return szMerchantMgtMapper.update(szMerchantMgt);
	}

	@Override
	public List<SzMerchantMgt> selectPageList(SzMerchantMgt params, Integer offset, Integer limit) {
		return szMerchantMgtMapper.selectPageList(params, offset, limit);
	}

	@Override
	public Long countByDoorNumber(SzMerchantMgt szMerchantMgt) {
		return szMerchantMgtMapper.countByDoorNumber(szMerchantMgt);
	}

	@Override
	public Long count(SzMerchantMgt szMerchantMgt) {
		return szMerchantMgtMapper.count(szMerchantMgt);
	}

	@Override
	public Long countByMerchantcode(SzMerchantMgt szMerchantMgt) {
		return szMerchantMgtMapper.countByMerchantcode(szMerchantMgt);
	}

	@Override
	public String selectMerchantcodeByName(SzMerchantMgt szMerchantMgt) {
		String merchant_code = "";
		List<SzMerchantMgt>  list = szMerchantMgtMapper.selectMerchantcodeByName(szMerchantMgt);
		if(list!=null && list.size()>0){
			merchant_code = list.get(0).getMerchant_code();
		}
		return merchant_code;
	}
		 
	
	

}
