package com.mass.biz.smart.joinMerchant.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.joinMerchant.dao.SzJoinMerchantMapper;
import com.mass.biz.smart.joinMerchant.model.SzJoinMerchant;
import com.mass.biz.smart.joinMerchant.service.SzJoinMerchantService;

@Service
public class SzJoinMerchantServiceImpl implements SzJoinMerchantService {

	@Autowired
	SzJoinMerchantMapper szJoinMerchantMapper;

	@Override
	public int insert(SzJoinMerchant szJoinMerchant) {
		return szJoinMerchantMapper.insert(szJoinMerchant);
	}

	@Override
	public int update(SzJoinMerchant szJoinMerchant) {
		return szJoinMerchantMapper.update(szJoinMerchant);
	}

	@Override
	public List<SzJoinMerchant> selectList(SzJoinMerchant szJoinMerchant,List<Integer> statuList) {
		return szJoinMerchantMapper.selectList(szJoinMerchant, statuList);
	}
	@Override
	public List<SzJoinMerchant> selectPageList(SzJoinMerchant szJoinMerchant,Integer pageIndex, Integer pageSize,List<Integer> statuList) {
		return szJoinMerchantMapper.selectPageList(szJoinMerchant, pageIndex, pageSize,statuList);
	}

	@Override
	public SzJoinMerchant getEntityByUserId(Long userid,String merchant_code,Integer state) {
		return szJoinMerchantMapper.getEntityByUserId(userid, merchant_code, state);
	}

	@Override
	public SzJoinMerchant getEntityById(Long rid) {
		return szJoinMerchantMapper.getEntityById(rid);
	}

	@Override
	public Long count(SzJoinMerchant szJoinMerchant,List<Integer> statuList) {
		return szJoinMerchantMapper.count(szJoinMerchant, statuList);
	}

	@Override
	public int insertDefaultPass(SzJoinMerchant szJoinMerchant) {
		return szJoinMerchantMapper.insertDefaultPass(szJoinMerchant);
	}
}
