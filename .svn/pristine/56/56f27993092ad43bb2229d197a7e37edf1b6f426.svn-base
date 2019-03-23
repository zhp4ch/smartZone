package com.mass.biz.news.service;


import java.util.List;

import com.mass.biz.news.model.NewInfo;

/**
 * 新闻信息service</p>
 *
 * @author lile
 * @version 1.0.0
 * @date 2017/08/17
 */
public interface NewsService {
	
	/**
     * 列表及条件查询
     * @param  NewInfo   新闻类信息
     * @param  pageIndex    页大小
     * @param  pageSize     页码
     */
     List<NewInfo> selectPageList(NewInfo newInfo,Integer pageIndex, Integer pageSize) ;

    /**
     * 添加新闻
     * @param newInfo  新闻信息
     * @return
     */
    NewInfo addEntity (NewInfo newInfo);
    
    /**
     * 修改新闻信息
     * @param id  该新闻信息id
     * @return
     */
    boolean editEntity(NewInfo newInfo);
    
    /**
     * 根据ID查询数据信息.
     * @param id         
     * @return
     */
    NewInfo getEntityById(Long id);
    
    /**
     * 删除新闻
     * @param id 该新闻信息id
     * @return
     */
    boolean deleteEntity (String id);
    
    /**
     * 发布新闻
     * @param  id    该新闻信息id
     * @param  publishId  发布人id
     * @param  publisher  发布人姓名
     */
    boolean publish(String id, Long publishId, String publisher);
    
    /**
     * 撤回发布(支持批量撤回)
     * @param id 该新闻信息id
     * @return
     */
    boolean recall(String id);
    
    /**
     * 根据ID查询发布状态.
     *
     * @param id           
     * @return
     */
	int getIsPublishById(Long id);
}
