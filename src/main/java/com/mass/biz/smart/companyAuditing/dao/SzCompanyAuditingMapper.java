package com.mass.biz.smart.companyAuditing.dao;

import com.mass.biz.smart.companyAuditing.model.SzCompanyAuditing;
import com.mass.biz.smart.merchant.model.SzMerchant;
import com.mass.biz.smart.user.model.SzUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SzCompanyAuditingMapper {

	List<SzCompanyAuditing> selectList(@Param("searchParams") SzCompanyAuditing params, @Param("offset") Integer offset, @Param("limit") Integer limit);
	
	int update(SzCompanyAuditing params);
	
	Long count(@Param("searchParams")SzCompanyAuditing companyAuditing);
}
