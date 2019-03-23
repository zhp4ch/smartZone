package com.mass.biz.smart.property.message.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.property.message.dao.MessageMapper;
import com.mass.biz.smart.property.message.model.Message;
import com.mass.biz.smart.property.message.service.MessageService;

/**
 *
 * 项目名称：anyanghl-ht
 * 类名称：MessageServiceImpl
 * 类描述：消息业务层
 * 创建人：yihai Zhao
 * 创建时间：2018年7月16日 上午9:07:18
 * 修改人：yihai Zhao
 * 修改时间：2018年7月16日 上午9:07:18
 * 
 * @version
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public Message addMessage(Message message) {
		 int i = messageMapper.addMessage(message);
		return i>0 ?message :null ;
	}

	@Override
	public List<Message> selectMessageList(Message message) {
		List<Message> list = this.messageMapper.selectMessageList(message);
		return list;
	}

	@Override
	public long selectReadCount(Long userId) {
		long count = this.messageMapper.selectReadCount(userId);
		return count;
	}

	@Override
	public boolean editMessageByUserId(Message message) {
		return 0<this.messageMapper.editMessageByUserId(message);
	}

	@Override
	public boolean editMessageById(Long id) {
		return 0<this.messageMapper.editMessageById(id);
	}

	@Override
	public boolean delMessage(Long id) {
		return 0<this.messageMapper.delMessage(id);
	}

	@Override
	public List<Message> selectMessageDetial(Message message) {
		List<Message> list = this.messageMapper.selectMessageDetial(message);
		return list;
	}

	@Override
	public Message getMessageById(Long id) {
		Message message = this.messageMapper.getMessageById(id);
		return message;
	}

	@Override
	public void updateReadByUserId(Long userId) {
		this.messageMapper.updateReadByUserId(userId);
	}

	@Override
	public long selectNotReadCount(Long userId) {
		return messageMapper.selectNotReadCount(userId);
	}
}
