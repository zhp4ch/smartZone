package com.mass.biz.smart.merchantScore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.merchantScore.model.SzMerchantScore;
import com.mass.biz.smart.merchantScore.service.SzMerchantScoreService;
import com.mass.core.utils.AjaxResponse;

/**
 * 商户积分
 * @author jiangd
 */
@RestController
@RequestMapping("/wx/merchantScore")
public class SzMerchantScoreWXController {

	@Autowired
	SzMerchantScoreService merchantScoreService;

	/**
	 * 商户积分列表
	 * @param szMerchantScore
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/indexList", method = RequestMethod.GET)
	public AjaxResponse indexList(SzMerchantScore szMerchantScore, @RequestParam(value = "page") Integer pageIndex,
			@RequestParam(value = "limit") Integer pageSize) {
		
		Long count = merchantScoreService.indexListCount(szMerchantScore);
		List<SzMerchantScore> list = merchantScoreService.selectIndexList(szMerchantScore, (pageIndex-1)*pageSize, pageSize);
		return AjaxResponse.success("ok", list, count, pageIndex);
	}
	
	/**
	 * 指定商户的积分增减详情
	 * @param szMerchantScore
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public AjaxResponse list(SzMerchantScore szMerchantScore, @RequestParam(value = "page") Integer pageIndex,
			@RequestParam(value = "limit") Integer pageSize) {
		Long count = merchantScoreService.count(szMerchantScore);
		List<SzMerchantScore> list = merchantScoreService.selectPageList(szMerchantScore, (pageIndex-1)*pageSize, pageSize);
		return AjaxResponse.success("ok", list, count, pageIndex);
	}
	
	/**
	 * 指定商户最新积分
	 * @param szMerchantScore
	 * @return
	 */
	@RequestMapping(value = "/selectThelastScore", method = RequestMethod.GET)
	public AjaxResponse selectThelastScore(SzMerchantScore szMerchantScore) {
		Long score = merchantScoreService.selectThelastScore(szMerchantScore);
		return AjaxResponse.success("ok", score);
	}
	
	
	
}
