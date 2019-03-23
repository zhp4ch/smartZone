package com.mass.biz.news.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.news.dao.NewsMapper;
import com.mass.biz.news.model.NewInfo;
import com.mass.biz.news.service.NewsService;
import com.mass.core.sys.file.model.FileInfo;
import com.mass.core.sys.file.service.FileUploadService;
import com.mass.core.utils.DateUtils;


/**
 * 新闻信息service实现类</p>
 *
 * @author lile
 * @version 1.0.0
 * @date 2017/08/17
 */
@Service
public class NewsServiceImpl  implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private FileUploadService fileUploadService;
    
    /**
     * 列表及条件查询
     * @param  NewInfo   新闻类信息
     * @param  pageIndex    页大小
     * @param  pageSize     页码
     */
    public List<NewInfo> selectPageList(NewInfo newInfo, Integer pageIndex, Integer pageSize) {
    	List<NewInfo> page = newsMapper.selectPageList(newInfo, pageIndex, pageSize);
        return page;
    }
    
    /**
     * 新增新闻
     * @param id
     * @return  
     */
    public NewInfo addEntity(NewInfo newInfo) {
          
    	boolean b = 0<this.newsMapper.insert(newInfo);
    	return b ? newInfo : null;
    }
    /**
	 * 根据ID查询数据信息.
	 * @param id      查询条件
	 * @return
	 */
    public NewInfo getEntityById(Long id) {
    	newsMapper.updateClickRate(id);  //浏览次数加1
    	return this.newsMapper.getEntityById(id);
	}

	/**
	 * 修改新闻信息
	 * @param id
	 * @return
	 */
    public boolean editEntity(NewInfo newInfo) {
    
    	return 0<this.newsMapper.update(newInfo);
    }
      
    /**
     * 删除新闻（支持批量删除）
     * @param id
     * @return  
     */
    public boolean deleteEntity(String id) {
    	String ids[] = id.split(",");
    	int i = 0;
    	for (String idStr : ids){
    		i = this.newsMapper.delete(Long.valueOf(idStr));
    	}
    	return 0<i;
    }
      
    /**
     * 发布新闻（支持批量发布）
     * @param  id    该新闻信息id
     * @param  publishId  发布人id
     * @param  publisher  发布人姓名
     */
    public boolean publish(String id, Long publishId, String publisher){
    	String ids[] = id.split(",");
    	int i = 0;
    	for (String idStr : ids){
    		i = this.newsMapper.publish(Long.valueOf(idStr), publishId, publisher);
    	}
    	return 0<i;
    }

    /**
     * 撤回发布（支持批量撤回）
     * @param id
     * @return
     */
	public boolean recall(String id){
		String ids[] = id.split(",");
		int i = 0;
        for (String idStr : ids){
        	i = this.newsMapper.recall(Long.valueOf(idStr));
        }
        return 0<i;
	}

    /**
  	* 根据ID查询数据发布状态值.
  	*
  	* @param id                查询条件
  	* @return 
  	*/
  	public int getIsPublishById(Long id) {
  		return this.newsMapper.getIsPublishById(id);
  	}
}
