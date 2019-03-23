package com.mass.biz.smart.sign.service;

import java.util.List;

import com.mass.biz.smart.sign.model.SignRule;

/**
 * 打卡规则的接口
 * @author 
 * @date 2018-07-25
 *
 */
public interface SignRuleService {

		/**
		 * 条件查询
		 * @param signRule
		 * @param pageIndex
		 * @param pageSize
		 * @return
		 */
		List<SignRule> selectPageList(SignRule signRule,Integer pageIndex,Integer pageSize);
		
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
		SignRule insert(SignRule signRule);
		
		/**
		 * 修改
		 * @param signRule
		 * @return
		 */
		Integer update(SignRule signRule);
		
		/**
		 * 根据id删除
		 * @param rid
		 * @return
		 */
		Integer delete(Long rid);
		
		/**
		 * 根据身份证号码查询出所属公司的打卡规则
		 * @param idCode
		 * @return
		 */
		SignRule getIdCode(String idCode);
		
		/**
		 * 查询是否存在打卡规则
		 * @param merchantId
		 * @return
		 */
		SignRule getMerchantId(Long merchantId);
		
		List<SignRule> getAllSignMerchant();
}
