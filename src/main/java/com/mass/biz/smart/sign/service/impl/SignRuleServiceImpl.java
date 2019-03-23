package com.mass.biz.smart.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.sign.dao.SignRuleMapper;
import com.mass.biz.smart.sign.model.SignRule;
import com.mass.biz.smart.sign.service.SignRuleService;

/**
 * 打卡规则的实现类
 * @author 
 * @date 2018-07-25
 *
 */
@Service
public class SignRuleServiceImpl implements SignRuleService{

	@Autowired
	private SignRuleMapper signRuleMapper;
	
	/**
	 * 条件查询
	 */
	@Override
	public List<SignRule> selectPageList(SignRule signRule, Integer pageIndex,
			Integer pageSize) {
		
			List<SignRule> list=signRuleMapper.selectPageList(signRule, pageIndex, pageSize);
			return list;
	}

	/**
	 * 查询条数
	 */
	@Override
	public long count(SignRule signRule) {
		return signRuleMapper.count(signRule);
	}

	/**
	 * 新增
	 */
	@Override
	public SignRule insert(SignRule signRule) {
		boolean add = 0<signRuleMapper.insert(signRule);
		return add ? signRule :null;
	}

	/**
	 * 修改
	 */
	@Override
	public Integer update(SignRule signRule) {
		return signRuleMapper.update(signRule);
	}

	/**
	 * 根据id删除
	 */
	@Override
	public Integer delete(Long rid) {
		return signRuleMapper.delete(rid);
	}

	/**
	 * 根据身份证号码查询所属公司的打卡规则
	 */
	@Override
	public SignRule getIdCode(String idCode) {
		return signRuleMapper.getIdCode(idCode);
	}

	/**
	 * 查询是否存在打卡规则
	 */
	@Override
	public SignRule getMerchantId(Long merchantId) {
		
		return signRuleMapper.getMerchantId(merchantId);
	}
	
	@Override
	public List<SignRule> getAllSignMerchant() {
		return signRuleMapper.getAllSignMerchant();
	}

}
