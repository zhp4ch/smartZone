package com.mass.biz.smart.topic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.topic.model.TopicModel;

/**
 * 社交论坛的dao层
 * @author 
 * @date 2018-07-24
 *
 */
@Mapper
public interface TopicMapper {

		/**
		 * 条件查询
		 * @param topicModel
		 * @param offset
		 * @param limit
		 * @return
		 */
		List<TopicModel> selectPageList(@Param("searchParams") TopicModel topicModel,
				@Param("offset") Integer offset, @Param("limit") Integer limit);
		
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
		int delete(@Param("rid")Long rid);
		
		/**
		 * 根据rid查询
		 * @param rid
		 * @return 
		 */
		TopicModel getEntityId(@Param("rid") Long rid);
		
		/**
		 * 浏览次数加1
		 * @param rid
		 * @return
		 */
		int updateViewCount(@Param("rid") Long rid);
		
		/**
		 * 新增
		 * @param topicModel
		 * @return
		 */
		int insert(TopicModel topicModel);
}
