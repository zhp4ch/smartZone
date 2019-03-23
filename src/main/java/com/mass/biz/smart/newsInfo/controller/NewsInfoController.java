package com.mass.biz.smart.newsInfo.controller;

import static com.mass.core.utils.AjaxResponse.FAILURE_ADD_ENTITY;

import java.text.SimpleDateFormat;
import java.util.Date;
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
 * 新闻信息的控制层
 * @author 
 * @date 2017-07-17
 *
 */
@RestController
@RequestMapping(value="/newsInfo")
public class NewsInfoController {

    	private final static Logger LOGGER = LoggerFactory.getLogger(NewsInfoController.class);

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
		
		@LogAop(menuName="新闻管理",operationDesc="新增",operationType="1")
	    @RequestMapping(value="/inserts", method = RequestMethod.POST)
		public AjaxResponse addEntiy(NewsInfo newsInfo){
			
			return null == newsInfoSerice.addEntiy(newsInfo) ? 
				new AjaxResponse(FAILURE_ADD_ENTITY, "error",newsInfo)
			: AjaxResponse.success("ok",newsInfo);
			
		}

		@LogAop(menuName="新闻管理",operationDesc="修改",operationType="2")
		@RequestMapping(value="/update", method = RequestMethod.POST)
		 public AjaxResponse updateEntiy(NewsInfo newsInfo){
			//获取当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
				newsInfo.setPublishTime(df.format(new Date()));
	
			 Integer count=newsInfoSerice.updateEntiy(newsInfo);
			 if(count==1){
				return AjaxResponse.success("ok",newsInfo);
			 }else{
				return AjaxResponse.error("no");
			 }
		 }
		 
		 @LogAop(menuName="新闻管理",operationDesc="删除",operationType="2")
		 @RequestMapping(value="/delete", method = RequestMethod.POST)
		 public AjaxResponse deleteEntiy(Long id){
			 Integer count=newsInfoSerice.deleteEntiy(id);
			 if(count==1){
				 return AjaxResponse.success("ok",id);
			 }else{
				 return AjaxResponse.error("no");
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
