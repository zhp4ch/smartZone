package com.mass.biz.smart.newsInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.newsInfo.dao.NewsInfoMapper;
import com.mass.biz.smart.newsInfo.model.NewsInfo;
import com.mass.biz.smart.newsInfo.service.NewsInfoService;


/**
 * 新闻信息的实现类
 * @author 
 * @date 2017-07-17
 *
 */
@Service
public class NewsInfoServiceImpl implements NewsInfoService{
	
		@Autowired
		private NewsInfoMapper newsInfoMapper;
		
	

		/**
		 * 条件查询
		 * @param newsInfo
		 * @param pageIndex
		 * @param pageSize
		 * @return
		 */
		@Override
		public List<NewsInfo> selectPageList(NewsInfo newsInfo, Integer pageIndex,
				Integer pageSize) {
			List<NewsInfo> list=newsInfoMapper.selectPageList(newsInfo, pageIndex, pageSize);
			return list;
		}

		/**
		 * 新增
		 * @param newsInfo
		 * @return
		 */
		@Override
		public NewsInfo addEntiy(NewsInfo newsInfo) {
			boolean b=0<newsInfoMapper.insert(newsInfo);
			
			return b ? newsInfo:null;
		}

		/**
		 * 修改
		 */
		@Override
		public Integer updateEntiy(NewsInfo newsInfo) {
			
			return newsInfoMapper.update(newsInfo);
		}

		/**
		 * 删除
		 */
		@Override
		public Integer deleteEntiy(Long id) {
		
			return newsInfoMapper.delete(id);
		}

		/**
		 * 查询条数
		 */
		@Override
		public long countNumber(NewsInfo newsInfo) {
			return newsInfoMapper.count(newsInfo);
		}

		/**
		 * 根据id查询
		 */
		@Override
		public NewsInfo getEntityId(Long id){
			//浏览次数自动加1
			newsInfoMapper.updateClickRate(id);
			
			return newsInfoMapper.getEntityId(id);
		}
}
