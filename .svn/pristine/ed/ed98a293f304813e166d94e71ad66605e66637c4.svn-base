package com.mass.biz.smart.property.message.service; 

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.property.message.model.Message;

/**
 *
 * 项目名称：anyanghl-ht
 * 类名称：MessageService
 * 类描述：messageService
 * 创建人：yihai Zhao
 * 创建时间：2018年7月16日 上午9:04:46
 * 修改人：yihai Zhao
 * 修改时间：2018年7月16日 上午9:04:46
 * 
 * @version
 *
 */
public interface MessageService {
	
	Message addMessage(Message message);
	
	boolean	editMessageByUserId(Message message);
	
	boolean editMessageById(Long id);
	
	List<Message> selectMessageList(Message message);
	
	long selectReadCount(Long userId);
	
	boolean delMessage(@Param("id")Long id);
	
	List<Message> selectMessageDetial(Message message);
	
	Message getMessageById(Long id);
	//根据用户id修改所有消息为已读
	void updateReadByUserId(Long userId);
	//未读催收消息总条数 
	long selectNotReadCount(Long userId);
}
