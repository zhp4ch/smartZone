package com.mass.biz.smart.newsInfo.service;

import java.util.List;

import com.mass.biz.smart.newsInfo.model.NewsInfo;

/**
 * 新闻信息的接口
 * @author 
 * @date 2017-07-17
 *
 */
public interface NewsInfoService {
		
		/**
		 * 条件查询
		 * @param newsInfo
		 * @param pageIndex
		 * @param pageSize
		 * @return
		 */
		List<NewsInfo> selectPageList(NewsInfo newsInfo,Integer pageIndex,Integer pageSize);
		
		/**
		 * 新增
		 * @param newsInfo
		 * @return
		 */
		NewsInfo addEntiy(NewsInfo newsInfo);
		
		/**
		 * 根据id修改
		 * @param newsInfo
		 * @return
		 */
		Integer updateEntiy(NewsInfo newsInfo);
		
		/**
		 * 根据id删除
		 * @param id
		 * @return
		 */
		Integer deleteEntiy(Long id);
		
		/**
		 * 查询条数
		 * @param newsInfo
		 * @return
		 */
		long countNumber(NewsInfo newsInfo);
		
		/**
		 * 根据id查询 
		 * @param id
		 * @return
		 */
		NewsInfo getEntityId(Long id);

}
