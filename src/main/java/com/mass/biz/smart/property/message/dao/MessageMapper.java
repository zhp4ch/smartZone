package com.mass.biz.smart.property.message.dao; 

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.property.message.model.Message;

/**
 *
 * 项目名称：anyanghl-ht
 * 类名称：MessageMapper
 * 类描述：消息dao
 * 创建人：yihai Zhao
 * 创建时间：2018年7月13日 下午3:39:00
 * 修改人：yihai Zhao
 * 修改时间：2018年7月13日 下午3:39:00
 * 
 * @version
 *
 */
@Mapper
public interface MessageMapper{
	
	//新增
	int addMessage(Message message);
	
	//更新已读标记  多条
	int	editMessageByUserId(Message message);
	
	//更新已读标记 单条
	int editMessageById(@Param("id")Long id);
	
	//list查询
	List<Message> selectMessageList(Message message);
	
	//查询未读总条数
	long selectReadCount(@Param("userId") Long userId);
	
	//删除
	int delMessage(@Param("id")Long id);
	
	//查询多条消息详情  --- 人与人聊天记录查询
	List<Message> selectMessageDetial(Message message);
	
	//根据id查询单条记录详情
	Message getMessageById(@Param("id")Long id);
	
	//根据用户id修改所有消息为已读
	void updateReadByUserId(Long userId);
	//未读催收消息总条数 
	long selectNotReadCount(Long userId);
}