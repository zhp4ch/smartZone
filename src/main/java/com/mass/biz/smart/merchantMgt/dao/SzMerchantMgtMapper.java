package com.mass.biz.smart.merchantMgt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.merchantMgt.model.SzMerchantMgt;

@Mapper
public interface SzMerchantMgtMapper {

	 int batchInsert(List<SzMerchantMgt> list);
	 
	 int update(SzMerchantMgt szMerchantMgt);
	 
	 List<SzMerchantMgt> selectPageList(@Param("searchParams") SzMerchantMgt params, @Param("offset") Integer offset, @Param("limit") Integer limit);

	 Long count(SzMerchantMgt szMerchantMgt);
	 /**
	  * 查询指定园区、指定门牌号是否已经入驻有效商户
	  * @param szMerchantMgt
	  * @return
	  */
	 Long countByDoorNumber(SzMerchantMgt szMerchantMgt);
	 
	 /**
	  * 
	  * @param szMerchantMgt
	  * @return
	  */
	 Long countByMerchantcode(SzMerchantMgt szMerchantMgt);
	 
	 /**
	  * 根据公司名称，获取公司编码
	  * @param szMerchantMgt
	  * @return
	  */
	 List<SzMerchantMgt> selectMerchantcodeByName(SzMerchantMgt szMerchantMgt);
}