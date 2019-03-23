package com.mass.biz.smart.topic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.topic.model.TopicReply;

/**
 * 话题评论回复的mapper
 * @author 
 * date 2018-07-25
 *
 */
@Mapper
public interface TopicReplyMapper {

		/**
		 * 条件查询
		 * @param topicReply
		 * @param offset
		 * @param limit
		 * @return
		 */
		List<TopicReply> selectPageList(@Param("searchParams")TopicReply topicReply,
				@Param("offset")Integer offset,@Param("limit") Integer limit);
		
		/**
		 * 查询条数
		 * @param topicReply
		 * @return
		 */
		long count(@Param("topicReply")TopicReply topicReply);
		
		/**
		 * 根据删除查询
		 * @param rid
		 * @return
		 */
		int delete(@Param("rid") Long rid);
		
		/**
		 * 根据id查询
		 * @param rid
		 * @return
		 */
		TopicReply getById(@Param("rid") Long rid);
		
		/**
		 * 根据话题id,查询话题评论的条数
		 * @param topicId
		 * @return
		 */
		long replyCount(@Param("topicId") Long topicId);
		
		/**
		 * 根据话题id，新增一条评论
		 * @param topicId
		 * @return
		 */
		int insertReply(TopicReply topicReply);
		
}