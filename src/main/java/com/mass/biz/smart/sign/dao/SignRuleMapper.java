package com.mass.biz.smart.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.sign.model.SignRule;

/**
 * 打卡规则的mapper
 * @author 
 * @date 2018-07-25
 *
 */
@Mapper
public interface SignRuleMapper {
	
		/**
		 * 条件查询
		 * @param signRule
		 * @param offest
		 * @param limit
		 * @return
		 */
		List<SignRule> selectPageList(@Param("searchParams")SignRule signRule,
				@Param("offset")Integer offset,@Param("limit")Integer limit);
		
		/**
		 * 查询条数
		 * @param signRule
		 * @return
		 */
		long count(SignRule signRule);
		
		/**
		 * 新增
		 * @param signRule
		 * @return
		 */
		int insert(SignRule signRule);
		
		/**
		 * 修改
		 * @param signRule
		 * @return
		 */
		int update(SignRule signRule);
		
		/**
		 * 根据id删除
		 * @param rid
		 * @return
		 */
		int delete(@Param("rid")Long rid);
		
		/**
		 * 根据身份证号码查询所属公司的打卡规则
		 * @param idCode
		 * @return
		 */
		SignRule getIdCode(@Param("idCode")String idCode);
		
		/**
		 * 查询是否存在打卡规则
		 * @param merchantId
		 * @return
		 */
		SignRule getMerchantId(@Param("merchantId")Long merchantId);
		
		List<SignRule> getAllSignMerchant();

}
