package com.mass.biz.smart.companyAuditing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.companyAuditing.dao.SzCompanyAuditingMapper;
import com.mass.biz.smart.companyAuditing.model.SzCompanyAuditing;
import com.mass.biz.smart.companyAuditing.service.SzCompanyAuditingService;
@Service
public class SzCompanyAuditingServiceImpl implements SzCompanyAuditingService{
	@Autowired
	private  SzCompanyAuditingMapper companyAuditingMapper;
	
	@Override
	public List<SzCompanyAuditing> selectList(SzCompanyAuditing params, Integer offset, Integer limit) {
		return companyAuditingMapper.selectList(params, offset, limit);
	}

	@Override
	public int update(SzCompanyAuditing params) {
		return companyAuditingMapper.update(params);
	}

	@Override
	public Long count(SzCompanyAuditing companyAuditing) {
		return companyAuditingMapper.count(companyAuditing);
	}
	


}
