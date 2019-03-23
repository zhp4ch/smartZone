package com.mass.biz.smart.sign.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.sign.model.SignRule;
import com.mass.biz.smart.sign.service.SignRuleService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;
/**
 * 打卡规则Controller
 * @author vm3
 * @date 2018-07-25
 *
 */
@RestController
@RequestMapping(value="/signRule")
public class SignRuleController {
	
		private final static Logger LOGGER = LoggerFactory.getLogger(SignRuleController.class);

		@Autowired
		private SignRuleService signRuleService;
		
		@LogAop(menuName="打卡规则",operationDesc="查询",operationType="3")
	    @RequestMapping(value="/list", method = RequestMethod.GET)
		public AjaxResponse list(SignRule signRule,
				@RequestParam("page")Integer pageIndex,
				@RequestParam("limit")Integer pageSize){
			try{
				Long count=signRuleService.count(signRule);
				List<SignRule> list=signRuleService.selectPageList(signRule, (pageIndex-1)*pageSize,
						pageSize);
				return AjaxResponse.success("ok", list, count, pageIndex);
				
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("Select SignRule error!",e);
				return null;
			}
		}
		
		@LogAop(menuName="打卡规则",operationDesc="新增",operationType="3")
	    @RequestMapping(value="/insert", method = RequestMethod.POST)
		public AjaxResponse insert(SignRule signRule){
			
				return null == signRuleService.insert(signRule) 
						? new AjaxResponse("FAILURE_ADD_ENTITY", "error", signRule)
						: AjaxResponse.success("ok",signRule);
		
		}
		
		@LogAop(menuName="打卡规则",operationDesc="修改",operationType="3")
	    @RequestMapping(value="/update", method = RequestMethod.POST)
		public AjaxResponse update(SignRule signRule){
			Integer count=signRuleService.update(signRule);
			if(count==1){
				return AjaxResponse.success("ok",signRule);
			}else{
				return AjaxResponse.error("no");
			}
		}
		
		@LogAop(menuName="打卡规则",operationDesc="删除",operationType="3")
	    @RequestMapping(value="/delete", method = RequestMethod.POST)
		public AjaxResponse delete(Long rid){
			Integer count =signRuleService.delete(rid);
			if(count==1){
				return AjaxResponse.success("ok",rid);
			}else{
				return AjaxResponse.error("no");
			}
		}
		
		@LogAop(menuName="打卡规则",operationDesc="根据身份证号码查询所属公司的打卡规则",operationType="3")
	    @RequestMapping(value="/getIdCode", method = RequestMethod.GET)
		public AjaxResponse getIdCode(String idCode){
			try{
				SignRule signRule=signRuleService.getIdCode(idCode);
				return AjaxResponse.success("ok",signRule);
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("select idCode error!",e);
				return null;
			}
		}
		
		@LogAop(menuName="打卡规则",operationDesc="根据商户id查询公司是否存在打卡规则",operationType="3")
	    @RequestMapping(value="/getMerchantId", method = RequestMethod.GET)
			public AjaxResponse getMerchantId(Long merchantId){
				try{
					SignRule list=signRuleService.getMerchantId(merchantId);
					return AjaxResponse.success("ok",list);
				}catch(Exception e){
					e.printStackTrace();
					LOGGER.error("select getMerchantId error!",e);
					return null;
				}
			}
		
		/**
		 * 查询已有打卡规则的商户
		 * @return
		 */
		@RequestMapping(value="/getAllSignMerchant", method = RequestMethod.GET)
		public List<SignRule> getAllSignMerchant(){
			return signRuleService.getAllSignMerchant();
		}
		
}
