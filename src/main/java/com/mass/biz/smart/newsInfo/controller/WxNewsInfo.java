package com.mass.biz.smart.newsInfo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.newsInfo.model.NewsInfo;
import com.mass.biz.smart.newsInfo.service.NewsInfoService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 微信端访问的接口
 * @author 
 * @date 2018-08-01
 *
 */
@RestController
@RequestMapping(value="/wx/newsInfo")
public class WxNewsInfo {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(WxNewsInfo.class);

	@Autowired
	private NewsInfoService newsInfoSerice;
	
	@LogAop(menuName="新闻管理",operationDesc="查询",operationType="3")
    @RequestMapping(value="/list", method = RequestMethod.GET)
	public AjaxResponse list(NewsInfo newsInfo, 
            @RequestParam(value = "page") Integer pageIndex,
            @RequestParam(value = "limit") Integer pageSize){
		try{
			Long count  = newsInfoSerice.countNumber(newsInfo);
			List<NewsInfo> list=newsInfoSerice.selectPageList(newsInfo,(pageIndex-1)*pageSize, pageSize);
			return AjaxResponse.success("ok", list, count, pageIndex);
		}catch (Exception e){
        	e.printStackTrace();
            LOGGER.error("select NewsInfo error!", e);
            return null;
        }
		
	}
	
	@LogAop(menuName="新闻管理",operationDesc="根据id查询",operationType="2")
	 @RequestMapping(value="/getEntityId", method = RequestMethod.GET)
	 public AjaxResponse getEntityId(Long id){
		 try{
			 NewsInfo newsInfo=newsInfoSerice.getEntityId(id);
			 return AjaxResponse.success("ok",newsInfo);
		 }catch(Exception e){
			 e.printStackTrace();
			 LOGGER.error("select NewsInfo error!", e);
	            return AjaxResponse.error("error");
		 }
	 }

}
