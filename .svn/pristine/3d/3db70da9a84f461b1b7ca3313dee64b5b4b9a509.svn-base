package com.mass.biz.smart.topic.service;

import java.util.List;

import com.mass.biz.smart.topic.model.TopicModel;

/**
 * 社交论坛的接口
 * @author 
 * @date 2018-07-24
 *
 */
public interface TopicService {

		/**
		 * 条件查询
		 * @param topicModel
		 * @return
		 */
		List<TopicModel> selectPageList(TopicModel topicModel,
				Integer pageIndex,Integer pageSize);
		
		/**
		 * 查询总条数
		 * @param topicModel
		 * @return
		 */
		long count(TopicModel topicModel);
		
		/**
		 * 根据rid删除
		 * @param rid
		 * @return
		 */
		Integer delete(Long rid);
		
		/**
		 * 根据rid查询
		 * @param rid
		 * @return
		 */
		TopicModel getEntityId(Long rid);
		
		/**
		 * 新增
		 * @param topicModel
		 * @return
		 */
		TopicModel topicAdd(TopicModel topicModel);
}
