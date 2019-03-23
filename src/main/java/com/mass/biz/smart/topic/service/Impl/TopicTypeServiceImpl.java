package com.mass.biz.smart.topic.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.topic.mapper.TopicTypeMapper;
import com.mass.biz.smart.topic.model.TopicType;
import com.mass.biz.smart.topic.service.TopicTypeService;

/**
 * 频道的实现类
 * @author computer
 *
 */
@Service
public class TopicTypeServiceImpl implements TopicTypeService {
	
	@Autowired
	private TopicTypeMapper topicTypeMapper;

	/**
	 * 条件查询，分页
	 */
	@Override
	public List<TopicType> selectPage(TopicType topicType, Integer pageIndex,
			Integer pageSize) {
		List<TopicType> list=topicTypeMapper.selectPageList(topicType, pageIndex, pageSize);
		return list;
	}

	/**
	 * 查询条数
	 */
	@Override
	public long count(TopicType topicType) {
		
		return topicTypeMapper.count(topicType);
	}

	/**
	 * 新增
	 */
	@Override
	public TopicType insert(TopicType topicType) {
		
		boolean add = 0<topicTypeMapper.insertType(topicType);
		return add ? topicType : null;
	}

	/**
	 * 修改
	 */
	@Override
	public Integer update(TopicType topicType) {
		
		return topicTypeMapper.updateType(topicType);
	}

	/**
	 * 删除
	 */
	@Override
	public Integer delete(Long rid) {
		
		return topicTypeMapper.delete(rid);
	}

	@Override
	public TopicType getTypeName(String typeName) {
		
		return topicTypeMapper.getTypeName(typeName);
	}

}
