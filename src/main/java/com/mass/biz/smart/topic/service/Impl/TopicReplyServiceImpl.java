package com.mass.biz.smart.topic.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.topic.mapper.TopicReplyMapper;
import com.mass.biz.smart.topic.model.TopicReply;
import com.mass.biz.smart.topic.service.TopicReplyService;

/**
 * 话题评论回复的实现类
 * @author 
 * @date 2018-07-25
 *
 */
@Service
public class TopicReplyServiceImpl implements TopicReplyService {

	@Autowired
	private TopicReplyMapper topicReplyMapper;
	
	/**
	 * 条件查询
	 */
	@Override
	public List<TopicReply> selectPageList(TopicReply topicReply,
			Integer pageIndex, Integer pageSize) {
		List<TopicReply> list=topicReplyMapper.selectPageList(topicReply, pageIndex, pageSize);
		return list;
	}

	/**
	 * 查询条数
	 */
	@Override
	public long count(TopicReply topicReply) {
		return topicReplyMapper.count(topicReply);
	}

	/**
	 * 根据id删除
	 */
	@Override
	public Integer delete(Long rid) {
		return topicReplyMapper.delete(rid);
	}

	/**
	 * 根据话题id，查询话题评论的数据
	 */
	@Override
	public long replyCount(Long topicId) {
		return topicReplyMapper.replyCount(topicId);
	}

	/**
	 * 根据话题id，新增一条评论
	 */
	@Override
	public Integer insertReply(TopicReply topicReply) {
		
		return topicReplyMapper.insertReply(topicReply);
	}

	@Override
	public TopicReply getById(Long rid) {
		return topicReplyMapper.getById(rid);
	}

}
