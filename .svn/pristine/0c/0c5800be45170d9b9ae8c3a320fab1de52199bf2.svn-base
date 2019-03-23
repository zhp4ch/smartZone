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

import com.mass.biz.smart.merchantScore.model.SzMerchantScore;
import com.mass.biz.smart.merchantScore.service.SzMerchantScoreService;
import com.mass.biz.smart.topic.model.TopicModel;
import com.mass.biz.smart.topic.model.TopicReply;
import com.mass.biz.smart.topic.model.TopicType;
import com.mass.biz.smart.topic.service.TopicReplyService;
import com.mass.biz.smart.topic.service.TopicService;
import com.mass.biz.smart.topic.service.TopicTypeService;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.biz.utils.PayCommonUtil;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 
 * @author jiangd
 */
@RestController
@RequestMapping(value="/wx/topic")
public class TopicWXController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	SzMerchantScoreService merchantScoreService;
	
	@Autowired
	SzUserService szUserService;
	
	@Autowired
	private TopicReplyService topicReplyService;
	
	@Autowired
	private TopicTypeService topicTypeService;
	
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
		boolean b = false;
		if(null != topicService.topicAdd(topicModel) ){
			b = true;
			merchantScoreService.outsideInsert(topicModel.getUser_id(), SzMerchantScore.TOPIC_PUBLISH_TYPE);
		}
		return b?AjaxResponse.success("ok",topicModel) : new AjaxResponse(FAILURE_ADD_ENTITY, "error",topicModel);
				
	}
	
	
	
	@LogAop(menuName="话题评论回复",operationDesc="查询",operationType="3")
    @RequestMapping(value="/listCount", method = RequestMethod.GET)
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
	
	@LogAop(menuName="新增话题评论",operationDesc="新增",operationType="3")
    @RequestMapping(value="/insertReply", method = RequestMethod.POST)
	public AjaxResponse insertReply(TopicReply topicReply){
		Integer count=topicReplyService.insertReply(topicReply);
		if(count==1){
			merchantScoreService.outsideInsert(topicReply.getUser_id(), SzMerchantScore.TOPIC_ARGUED_TYPE);
			 String openid = "";
			 String content = "";
			if(topicReply.getTopicId()!=null) {
				//topicId不为空则说明是评论的,应该给发贴人推送消息
				//获取发贴人的相关信息6
				TopicModel topicModel =topicService.getEntityId(topicReply.getTopicId());
				openid = topicModel.getOpenId();
				content = "<a href = \""+PayCommonUtil.url+"/via.html?mold=topicMain&topicid="+topicReply.getTopicId()+"\">"+"您的话题有新的评论!</a>";
			}else {//topicId为空说明是回复的,跟评论人发消息
				   //查询评论人的那条记录,为了获取评论人openid
				TopicReply reply =topicReplyService.getById(topicReply.getReplyId());
				openid = reply.getOpenId();
				content = "<a href = \""+PayCommonUtil.url+"/via.html?mold=PostDetail&topicid="+reply.getTopicId()+"\">"+"你评论的话题有新的回复!</a>";
			}
			szUserService.sendWXMessage(openid, content);
			return AjaxResponse.success("ok",topicReply);
		}else{
			return AjaxResponse.error("no");
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
	
	@LogAop(menuName="社交论坛频道",operationDesc="查询",operationType="3")
    @RequestMapping(value="/listType", method = RequestMethod.GET)
	public AjaxResponse list(TopicType topicType,
			@RequestParam("page")Integer pageIndex,
			@RequestParam("limit")Integer pageSize){
		try{
			Long count=topicTypeService.count(topicType);
			List<TopicType> list = topicTypeService.selectPage(topicType, 
					(pageIndex-1)*pageSize, pageSize);
			return AjaxResponse.success("ok", list, count, pageIndex);
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.error("select TopicModel error!", e);
            return null;
		}
		
	}
}
