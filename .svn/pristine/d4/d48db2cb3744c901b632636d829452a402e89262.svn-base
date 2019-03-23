package com.mass.biz.smart.topic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.topic.model.TopicType;

/**
 * 频道的dao层
 * @author computer
 *
 */
@Mapper
public interface TopicTypeMapper {

	/**
	 * 条件查询,分页
	 * @param topicType
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<TopicType> selectPageList(@Param("searchParams")TopicType topicType,
			@Param("offset")Integer offset,@Param("limit") Integer limit);
	
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
	int insertType(TopicType topicType);
	
	/**
	 * 修改
	 * @param topicType
	 * @return
	 */
	int updateType(TopicType topicType);
	
	/**
	 * 删除
	 * @param rid
	 * @return
	 */
	int delete(@Param("rid")Long rid);
	
	/**
	 * 验证频道名称是否存在
	 * @param typeName
	 * @return
	 */
	TopicType getTypeName(@Param("typeName") String typeName);
	
}
