package com.mass.biz.smart.topic.controller;

import static com.mass.core.utils.AjaxResponse.FAILURE_ADD_ENTITY;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.topic.model.TopicModel;
import com.mass.biz.smart.topic.service.TopicService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 社交论坛的控制层
 * @author 
 * @date 2018-07-24
 *
 */
@RestController
@RequestMapping(value="/topic")
public class TopicController {

		private final static Logger LOGGER = LoggerFactory.getLogger(TopicController.class);
	
		@Autowired
		private TopicService topicService;
		
		@LogAop(menuName="社交论坛",operationDesc="查询",operationType="3")
	    @RequestMapping(value="/list", method = RequestMethod.GET)
		public AjaxResponse list(TopicModel topicModel,
				@RequestParam("page")Integer pageIndex,
				@RequestParam("limit")Integer pageSize){
			try{
				Long count=topicService.count(topicModel);
				List<TopicModel> list=topicService.selectPageList(topicModel, 
						(pageIndex-1)*pageSize, pageSize);
				return AjaxResponse.success("ok", list, count, pageIndex);
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("select TopicModel error!", e);
	            return null;
			}
			
		}
		
		@LogAop(menuName="社交论坛",operationDesc="查询",operationType="3")
	    @RequestMapping(value="/delete", method = RequestMethod.POST)
		public AjaxResponse delete(Long rid){
			Integer count=topicService.delete(rid);
			if(count==1){
				return AjaxResponse.success("ok",rid);
			}else{
				return AjaxResponse.error("no");
			}
		}
		
		@LogAop(menuName="社交论坛",operationDesc="查询",operationType="3")
	    @RequestMapping(value="/getEntityId", method = RequestMethod.GET)
		public AjaxResponse getEntityId(Long rid){
			try{
				TopicModel topicModel=topicService.getEntityId(rid);
				return AjaxResponse.success("ok",topicModel);
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("select TopicModel error!", e);
				return null;
			}
		}
		
		@LogAop(menuName="社交论坛",operationDesc="新增",operationType="1")
	    @RequestMapping(value="/inserts", method = RequestMethod.POST)
		public AjaxResponse topicAdd(TopicModel topicModel){
			return null == topicService.topicAdd(topicModel) ?
					new AjaxResponse(FAILURE_ADD_ENTITY, "error",topicModel)
			: AjaxResponse.success("ok",topicModel);
		}
}
