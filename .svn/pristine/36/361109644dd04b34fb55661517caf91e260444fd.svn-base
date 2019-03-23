package com.mass.biz.smart.newsInfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.newsInfo.model.NewsInfo;

/**
 * 新闻信息的dao层
 * @author 
 * @date 2018-07-17
 *
 */
@Mapper
public interface NewsInfoMapper{

		/**
	 	* 条件查询
	 	* @param newsInfo
	 	* @param offset
	 	* @param limit
	 	* @return
	 	*/
		List<NewsInfo> selectPageList(@Param("searchParams")NewsInfo newsInfo,
			@Param("offset") Integer offset, @Param("limit") Integer limit);
	
		/**
		 * 查询总条数
		 * @param newsInfo
		 * @return
		 */
		long count(NewsInfo newsInfo);
		
		/**
		 * 新增一条记录
		 * @param newsInfo
		 * @return
		 */
		int insert(NewsInfo newsInfo); 
		
		/**
		 * 修改一条数据
		 * @param newsInfo
		 * @return
		 */
		int update(NewsInfo newsInfo);
		
		/**
		 * 根据id删除数据
		 * @param id
		 * @return
		 */
		int delete(@Param("id") Long id);
		
		/**
		 * 根据id查询
		 * @param id
		 * @return
		 */
		NewsInfo getEntityId(@Param("id") Long id);
		
		/**
		 * 浏览自动加1
		 * @param clickRate
		 * @return
		 */
		int updateClickRate(@Param("id") Long id);
		
}
