package com.mass.biz.smart.joinMerchant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.joinMerchant.model.SzJoinMerchant;
import com.mass.biz.smart.user.model.SzUser;

@Mapper
public interface SzJoinMerchantMapper {

	int insert(SzJoinMerchant szJoinMerchant);
	
	int update(SzJoinMerchant szJoinMerchant);
	
    List<SzJoinMerchant> selectList(@Param("searchParams") SzJoinMerchant params, @Param("statuList")List<Integer> statuList);
    
    List<SzJoinMerchant> selectPageList(@Param("searchParams") SzJoinMerchant params, @Param("offset") Integer offset, @Param("limit") Integer limit,@Param("statuList")List<Integer> statuList);
    
    SzJoinMerchant  getEntityByUserId(@Param("userid")Long userid,@Param("merchant_code")String merchant_code,@Param("state")Integer state );
    
    SzJoinMerchant  getEntityById(@Param("rid")Long rid);
    long  count(SzJoinMerchant szJoinMerchant,@Param("statuList")List<Integer> statuList);
    
    int insertDefaultPass(SzJoinMerchant szJoinMerchant);

}