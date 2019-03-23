package com.mass.biz.smart.property.message.controller; 

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.property.message.model.Message;
import com.mass.biz.smart.property.message.service.MessageService;
import com.mass.core.utils.AjaxResponse;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：MessageWxController
 * 类描述：消息控制层
 * 创建人：zx
 * 创建时间：2018年8月14日 上午10:15:23
 * 
 * @version
 *
 */
@RestController
@RequestMapping("/wx/message")
public class MessageWxController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MessageWxController.class);
	
	@Autowired
	private MessageService messageService;
	/**
	 * 
	* @Title: selectNotReadCount 
	* @Description: 未读催收消息总条数 
	* @param @param userId
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018年8月14日 14:08:36
	 */
	@RequestMapping("/selectNotReadCount")
	public AjaxResponse selectNotReadCount(@RequestParam("userId")Long userId){
		try {
			 long count = this.messageService.selectNotReadCount(userId);
			 return AjaxResponse.success("selectReadCount ok", count);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectReadCount error");
			return AjaxResponse.error("selectReadCount error");
		}
	}
	
	/**
	 * 
	* @Title: updateReadByUserId 
	* @Description: 根据用户id修改所有消息为已读 
	* @param @param userId
	* @author zx  
	* @date 2018年8月14日  10:25:12 
	 */
	@RequestMapping("/updateReadByUserId")
	public void updateReadByUserId(@RequestParam("userId")Long userId){
		try {
			 this.messageService.updateReadByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectReadCount error");
		}
	}
	/**
	 * 
	* @Title: addMessage 
	* @Description: 添加
	* @param @param message
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月16日 上午9:26:25 
	* @version V1.0
	 */
	@RequestMapping("/addMessage")
	public AjaxResponse addMessage(Message message){
		try {
			Message addMessage = this.messageService.addMessage(message);
			return AjaxResponse.success("addMessage ok", addMessage); 
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("addMessage error error");
			return AjaxResponse.error("addMessage error",message);
		}
	}
	/**
	 * 
	* @Title: editMessageByUserId 
	* @Description: 批量更新
	* @param @param userId
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月16日 上午9:30:37 
	* @version V1.0
	 */
	@RequestMapping("/editMessageByUserId")
	public AjaxResponse editMessageByUserId(Message message){
		try {
			return this.messageService.editMessageByUserId(message)?AjaxResponse.success("editMessageByUserId ok"):AjaxResponse.error("editMessageByUserId error");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("editMessageByUserId error");
			return AjaxResponse.error("editMessageByUserId error");
		}
	}
	/**
	 * 
	* @Title: editMessageById 
	* @Description: 单条更新
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月16日 上午9:32:46 
	* @version V1.0
	 */
	@RequestMapping("/editMessageById")
	public AjaxResponse editMessageById(@RequestParam("id")Long id){
		try {
			return this.messageService.editMessageById(id)?AjaxResponse.success("editMessageById ok"):AjaxResponse.error("editMessageById error");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("editMessageById error");
			return AjaxResponse.error("editMessageById error");
		}
	}
	/**
	 * 
	* @Title: selectMessageList 
	* @Description:列表查询
	* @param @param message
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月16日 上午9:35:47 
	* @version V1.0
	 */
	@RequestMapping("/selectMessageList")
	public AjaxResponse selectMessageList(Message message){
		try {
			List<Message> list = this.messageService.selectMessageList(message);
			return AjaxResponse.success("selectMessageList ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectMessageList error");
			return AjaxResponse.error("selectMessageList error",message);
		}
	}
	/**
	 * 
	* @Title: selectReadCount 
	* @Description: 未读总条数 
	* @param @param userId
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月16日 上午9:39:55 
	* @version V1.0
	 */
	@RequestMapping("/selectReadCount")
	public AjaxResponse selectReadCount(@RequestParam("userId")Long userId){
		try {
			 long count = this.messageService.selectReadCount(userId);
			 return AjaxResponse.success("selectReadCount ok", count);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectReadCount error");
			return AjaxResponse.error("selectReadCount error");
		}
	}
	/**
	 * 
	* @Title: delMessage 
	* @Description: 删除 
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月16日 上午9:44:13 
	* @version V1.0
	 */
	@RequestMapping("/delMessage")
	public AjaxResponse delMessage(@RequestParam("id")Long id){
		try {
			return this.messageService.delMessage(id)?AjaxResponse.success("delMessage ok"):AjaxResponse.error("delMessage error");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("delMessage error");
			return AjaxResponse.error("delMessage error");
		}
	}
	/**
	 * 
	* @Title: selectMessageDetial 
	* @Description: 聊天记录详情查询
	* @param @param message
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 上午10:53:36 
	* @version V1.0
	 */
	@RequestMapping("/selectMessageDetial")
	public AjaxResponse selectMessageDetial(Message message){
		try {
			List<Message> list = this.messageService.selectMessageDetial(message);
			return AjaxResponse.success("selectMessageDetial ok",list);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectMessageDetial error");
			return AjaxResponse.error("selectMessageDetial error", message);
		}
	}
	/**
	 * 
	* @Title: getMessageById 
	* @Description: 单条详情 
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 上午10:55:38 
	* @version V1.0
	 */
	@RequestMapping("/getMessageById")
	public AjaxResponse getMessageById(@RequestParam("id")Long id){
		try {
			Message message = this.messageService.getMessageById(id);
			return AjaxResponse.success("getMessageById ok",message);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("getMessageById error");
			return AjaxResponse.error("getMessageById error");
		}
	}
}
