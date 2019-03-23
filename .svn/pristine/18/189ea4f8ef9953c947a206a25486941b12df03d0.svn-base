package com.mass.biz.smart.topic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.topic.model.TopicReply;
import com.mass.biz.smart.topic.service.TopicReplyService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 话题评论回复的控制层
 * @author 
 * @date 208-07-25
 *
 */
@RestController
@RequestMapping(value="/topicReply")
public class TopicReplyController {
		
		private final static Logger LOGGER = LoggerFactory.getLogger(TopicReplyController.class);
	
		@Autowired
		private TopicReplyService topicReplyService;
		
		@LogAop(menuName="话题评论回复",operationDesc="查询",operationType="3")
	    @RequestMapping(value="/list", method = RequestMethod.GET)
		public AjaxResponse list(TopicReply topicReply,
				@RequestParam("page")Integer pageIndex,
				@RequestParam("limit")Integer pageSize){
			try{
				Long count=topicReplyService.count(topicReply);
				List<TopicReply> list=topicReplyService.selectPageList(topicReply,
						(pageIndex-1)*pageSize,pageSize);
				return AjaxResponse.success("ok", list, count, pageIndex);
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("select TopicReply error!",e);
				return null;
			}
		}
		
		@LogAop(menuName="话题评论回复",operationDesc="删除",operationType="3")
	    @RequestMapping(value="/delete", method = RequestMethod.POST)
		public AjaxResponse delete(Long rid){
			Integer count=topicReplyService.delete(rid);
			if(count==1){
				return AjaxResponse.success("ok",rid);
			}else{
				return AjaxResponse.error("error");
			}
		}
		
		@LogAop(menuName="话题评论回复",operationDesc="查询",operationType="3")
	    @RequestMapping(value="/replyCount", method = RequestMethod.GET)
		public AjaxResponse replyCount(Long topicId){
			try{
				Long count=topicReplyService.replyCount(topicId);
				return AjaxResponse.success("ok",count);
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("select topicId error!",e);
				return null;
			}
		}

}
