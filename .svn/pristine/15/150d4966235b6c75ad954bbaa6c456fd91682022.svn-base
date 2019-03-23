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

import com.mass.biz.smart.topic.model.TopicType;
import com.mass.biz.smart.topic.service.TopicTypeService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 频道的控制层
 * @author computer
 *
 */
@RestController
@RequestMapping(value="/topicType")
public class TopicTypeController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicTypeService topicTypeService;
	
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
	
	@LogAop(menuName="社交论坛频道",operationDesc="新增",operationType="1")
    @RequestMapping(value="/inserts", method = RequestMethod.POST)
	public AjaxResponse insert(TopicType topicType){
		return null == topicTypeService.insert(topicType) ?
				new AjaxResponse(FAILURE_ADD_ENTITY, "error",topicType)
		: AjaxResponse.success("ok",topicType);
	}
	
	@LogAop(menuName="社交论坛频道",operationDesc="查询",operationType="3")
    @RequestMapping(value="/update", method = RequestMethod.POST)
	public AjaxResponse update(TopicType topicType){
		Integer count=topicTypeService.update(topicType);
		if(count==1){
			return AjaxResponse.success("ok",topicType);
		}else{
			return AjaxResponse.error("no");
		}
	}
	
	@LogAop(menuName="社交论坛频道",operationDesc="查询",operationType="3")
    @RequestMapping(value="/delete", method = RequestMethod.POST)
	public AjaxResponse delete(Long rid){
		Integer count=topicTypeService.delete(rid);
		if(count==1){
			return AjaxResponse.success("ok",rid);
		}else{
			return AjaxResponse.error("no");
		}
	}
	
	@LogAop(menuName="社交论坛频道",operationDesc="查询频道是否存在",operationType="3")
    @RequestMapping(value="/getTypeName", method = RequestMethod.GET)
		public AjaxResponse getTypeName(String typeName){
			try{
				TopicType list=topicTypeService.getTypeName(typeName);
				return AjaxResponse.success("ok",list);
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error("select getMerchantId error!",e);
				return null;
			}
		}
}
