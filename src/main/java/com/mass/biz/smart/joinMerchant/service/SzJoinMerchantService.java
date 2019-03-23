package com.mass.biz.smart.joinMerchant.service;

import java.util.List;

import com.mass.biz.smart.joinMerchant.model.SzJoinMerchant;

public interface SzJoinMerchantService {
	
    int insert(SzJoinMerchant szJoinMerchant);
	
	int update(SzJoinMerchant szJoinMerchant);
	
    List<SzJoinMerchant> selectPageList(SzJoinMerchant szJoinMerchant,Integer pageIndex, Integer pageSize,List<Integer> statuList);
    List<SzJoinMerchant> selectList(SzJoinMerchant szJoinMerchant,List<Integer> statuList);
    
    SzJoinMerchant  getEntityByUserId(Long userid,String merchant_id,Integer state);
    
    SzJoinMerchant  getEntityById(Long rid);

	Long count(SzJoinMerchant szJoinMerchant,List<Integer> statuList);
	
    int insertDefaultPass(SzJoinMerchant szJoinMerchant);


}
