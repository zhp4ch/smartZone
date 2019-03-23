package com.mass.biz.smart.joinMerchant.controller;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.activiti.editor.language.json.converter.util.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.joinMerchant.model.SzJoinMerchant;
import com.mass.biz.smart.joinMerchant.service.SzJoinMerchantService;
import com.mass.biz.smart.merchant.model.SzMerchant;
import com.mass.biz.smart.merchant.service.SzMerchantService;
import com.mass.biz.smart.merchantScore.model.SzMerchantScore;
import com.mass.biz.smart.merchantScore.service.SzMerchantScoreService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.biz.utils.PayCommonUtil;
import com.mass.core.utils.AjaxResponse;

@RestController
@RequestMapping("/wx/joinMerchant")
public class SzJoinMerchantController {

	@Autowired
	SzJoinMerchantService szJoinMerchantService;
	@Autowired
	SzMerchantService szMerchantService;
	@Autowired
	SzMerchantScoreService szMerchantScoreService;
	@Autowired
	SzUserService szUserService;
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AjaxResponse list(SzJoinMerchant szJoinMerchant,Integer[] statuList) {
		List<SzJoinMerchant> list = szJoinMerchantService.selectList(szJoinMerchant,Arrays.asList(statuList));
		Long count = szJoinMerchantService.count(szJoinMerchant,Arrays.asList(statuList));
		return AjaxResponse.success("ok", list);
	}
	@RequestMapping(value = "/pagelist", method = RequestMethod.POST)
	public AjaxResponse pagelist(SzJoinMerchant szJoinMerchant, @RequestParam(value = "page") Integer pageIndex,
			@RequestParam(value = "limit") Integer pageSize,Integer[] statuList) {
		List<SzJoinMerchant> list = szJoinMerchantService.selectPageList(szJoinMerchant, (pageIndex - 1) * pageSize, pageSize,Arrays.asList(statuList));
		Long count = szJoinMerchantService.count(szJoinMerchant,Arrays.asList(statuList));
		return AjaxResponse.success("ok", list, count, pageIndex);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AjaxResponse update(SzJoinMerchant szJoinMerchant, HttpSession session) {
		
		int count = szJoinMerchantService.update(szJoinMerchant);
		//审核通过，则修改sz_user.merchant_id
		if(szJoinMerchant !=null && szJoinMerchant.getState()==1l && count>0){
			SzJoinMerchant merchant = szJoinMerchantService.getEntityById(szJoinMerchant.getRid());
			SzUser user = szUserService.getEntityById(merchant.getUser_id());
			user.setMerchant_code(merchant.getMerchant_code());
			szUserService.update(user);
			//加积分
			szMerchantScoreService.outsideInsert(merchant.getUser_id(), SzMerchantScore.USER_ENTER_TYPE);
			//向审请人推送审核通过消息
			SzUser zUser = szUserService.getEntityById(merchant.getUser_id());
			szUserService.sendWXMessage(zUser.getOpen_id(),"<a href = \""+PayCommonUtil.url+"/via.html?mold=myInfo\">"+"您加入的企业("+merchant.getCompaneyName()+")申请审核已通过!</a>");
		}
		return count >0 ? AjaxResponse.success("update ok") : AjaxResponse.error("update error");
	}

	@RequestMapping(value="/insert", method = RequestMethod.POST)
    public AjaxResponse insert(SzJoinMerchant szJoinMerchant, HttpSession session){
		SzJoinMerchant auditing  = szJoinMerchantService.getEntityByUserId(szJoinMerchant.getUser_id(),szJoinMerchant.getMerchant_code(), 0);
		SzJoinMerchant pass = szJoinMerchantService.getEntityByUserId(szJoinMerchant.getUser_id(),szJoinMerchant.getMerchant_code(), 1);
		SzJoinMerchant otherIsAuditing = szJoinMerchantService.getEntityByUserId(szJoinMerchant.getUser_id(),null, 0);
		SzJoinMerchant hasJoin = szJoinMerchantService.getEntityByUserId(szJoinMerchant.getUser_id(),null, 1);
		if(auditing!=null) {
			return  AjaxResponse.success("auditing");
		}else if (pass!=null) {
			return  AjaxResponse.success("pass");
		}else if (hasJoin!=null) {
			return  AjaxResponse.success("hasCompaney");
		}else if (otherIsAuditing!=null) {
			return  AjaxResponse.success("otherIsAuditing");
		}else {
	            	szJoinMerchantService.insert(szJoinMerchant);
	            	SzMerchant mer = szMerchantService.getEntityByCode(szJoinMerchant.getMerchant_code());
	            	SzUser user = szUserService.getEntityById(mer.getUserId());
	            	szUserService.sendWXMessage(user.getOpen_id(),"<a href = \""+PayCommonUtil.url+"/via.html?mold=myEmployees\">"+"您有新的员工待审批,请前往我的员工进行审批!</a>");
	            	return  AjaxResponse.success("add ok");
		}
    }
	

	@RequestMapping(value = "/showStatusByUserId", method = RequestMethod.POST)
	    public AjaxResponse showStatusByUserId(Long userId) {
		SzJoinMerchant szJoinMerchant  = szJoinMerchantService.getEntityByUserId(userId,null, -1);
	    	if(szJoinMerchant!=null) {
	    		//判断状态
	    		if(szJoinMerchant.getState().intValue()==0) {//待审核
	    			return  AjaxResponse.success("auditing");
	    		}else if(szJoinMerchant.getState().intValue()==1) {//已通过
	    				//查询出公司详情
	    			String companeyCode =szJoinMerchant.getMerchant_code();
	    			SzMerchant params = new SzMerchant();
	    			params.setMerchant_code(companeyCode);
	    			params.setExamineState(1);
	    			params.setMerchantState(1);
	    			List<SzMerchant> merchants =szMerchantService.selectByCondition(params);
	    			return  AjaxResponse.success("pass",CollectionUtils.isEmpty(merchants)?"":merchants.get(0));
	    		}else {
	    			return  AjaxResponse.success("refused");//已驳回
	    		}
	    	}else {
	    			return  AjaxResponse.success("normal");//正常
	    	}
	    }
    
}
