package com.mass.biz.smart.topic.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.topic.mapper.TopicMapper;
import com.mass.biz.smart.topic.model.TopicModel;
import com.mass.biz.smart.topic.service.TopicService;
/**
 * 社交论坛的实现类
 * @author 
 * @date 2018-07-24
 *
 */
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicMapper topicMapper;
	
	/**
	 * 条件查询
	 */
	@Override
	public List<TopicModel> selectPageList(TopicModel topicModel,Integer pageIndex,Integer pageSize) {

		List<TopicModel> list= topicMapper.selectPageList(topicModel, pageIndex, pageSize);
		return list;
	}

	/**
	 * 查询条数
	 */
	@Override
	public long count(TopicModel topicModel) {
		return topicMapper.count(topicModel);
	}

	/**
	 * 根据rid删除
	 */
	@Override
	public Integer delete(Long rid) {
		return topicMapper.delete(rid);
	}

	/**
	 * 根据rid查询
	 */
	@Override
	public TopicModel getEntityId(Long rid) {
		//浏览次数加1
		topicMapper.updateViewCount(rid);
		return topicMapper.getEntityId(rid);
	}

	/**
	 * 新增
	 */
	@Override
	public TopicModel topicAdd(TopicModel topicModel) {
		boolean add = 0<topicMapper.insert(topicModel);
		return add ? topicModel : null;
	}

}
