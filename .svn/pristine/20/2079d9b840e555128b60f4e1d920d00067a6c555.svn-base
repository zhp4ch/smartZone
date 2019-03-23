package com.mass.biz.smart.companyAuditing.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.companyAuditing.service.impl.SzCompanyAuditingServiceImpl;
import com.mass.biz.smart.joinMerchant.model.SzJoinMerchant;
import com.mass.biz.smart.joinMerchant.service.SzJoinMerchantService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.core.utils.AjaxResponse;
import com.mass.biz.smart.companyAuditing.model.SzCompanyAuditing;
import com.mass.biz.smart.companyAuditing.service.SzCompanyAuditingService;

@RestController
@RequestMapping("/szCompanyAuditing")
public class SzCompanyAuditingController {
	private SzCompanyAuditingService szCompanyAuditingService;

	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public AjaxResponse list(SzCompanyAuditing szCompanyAuditing , @RequestParam(value = "page") Integer pageIndex,
			@RequestParam(value = "limit") Integer pageSize) {
		Long count = szCompanyAuditingService.count(szCompanyAuditing);
		List<SzCompanyAuditing> list = szCompanyAuditingService.selectList(szCompanyAuditing, pageIndex, pageSize);
		return AjaxResponse.success("ok", list);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AjaxResponse update(SzCompanyAuditing szCompanyAuditing, HttpSession session) {
		int count = szCompanyAuditingService.update(szCompanyAuditing);
		return count >0 ? AjaxResponse.success("update ok") : AjaxResponse.error("update error");
	}

/*	@RequestMapping(value="/insert", method = RequestMethod.POST)
    public AjaxResponse insert(SzJoinMerchant szJoinMerchant, HttpSession session){
		SzJoinMerchant auditing  = szJoinMerchantService.getEntityByUserId(szJoinMerchant.getUser_id(),szJoinMerchant.getMerchant_id(), 0);
		SzJoinMerchant pass = szJoinMerchantService.getEntityByUserId(szJoinMerchant.getUser_id(),szJoinMerchant.getMerchant_id(), 1);
		if(auditing!=null) {
			return  AjaxResponse.success("auditing");
		}else if (pass!=null) {
			return  AjaxResponse.success("pass");
		}else {
			return szJoinMerchantService.insert(szJoinMerchant)>0 ? AjaxResponse.success("add ok") : AjaxResponse.error("add error");
		}
		
		
    }*/
    
}
