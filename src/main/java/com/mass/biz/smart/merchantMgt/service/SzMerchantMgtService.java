package com.mass.biz.smart.merchantMgt.service;

import java.util.List;


import com.mass.biz.smart.merchantMgt.model.SzMerchantMgt;

public interface SzMerchantMgtService {

	 int batchInsert(List<SzMerchantMgt> list);
	 
	 int update(SzMerchantMgt szMerchantMgt);
	 
	 List<SzMerchantMgt> selectPageList(SzMerchantMgt params,Integer offset,Integer limit);
	 
	 Long count(SzMerchantMgt szMerchantMgt);
	 
	 Long countByDoorNumber(SzMerchantMgt szMerchantMgt);
	 
	 Long countByMerchantcode(SzMerchantMgt szMerchantMgt);
	 
	 String selectMerchantcodeByName(SzMerchantMgt szMerchantMgt);


}
