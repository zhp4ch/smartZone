package com.mass.biz.smart.topic.service;

import java.util.List;

import com.mass.biz.smart.topic.model.TopicType;

/**
 * 频道的接口
 * @author computer
 *
 */
public interface TopicTypeService {

	/**
	 * 条件查询，分页
	 * @param topicType
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<TopicType> selectPage(TopicType topicType,
			Integer pageIndex,Integer pageSize);
	
	/**
	 * 查询条数
	 * @param topicType
	 * @return
	 */
	long count(TopicType topicType);
	
	/**
	 * 新增 
	 * @param topicType
	 * @return
	 */
	TopicType insert(TopicType topicType);
	
	/**
	 * 修改
	 * @param topicType
	 * @return
	 */
	Integer update(TopicType topicType);
	
	/**
	 * 删除
	 * @param rid
	 * @return
	 */
	Integer delete(Long rid);
	
	/**
	 * 验证频道是否存在
	 * @param topicType
	 * @return
	 */
	TopicType getTypeName(String typeName);
}
