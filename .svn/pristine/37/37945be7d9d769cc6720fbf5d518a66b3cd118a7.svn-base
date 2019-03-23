package com.mass.biz.news.controller;

import static com.mass.core.utils.AjaxResponse.FAILURE_ADD_ENTITY;
import static com.mass.core.utils.AjaxResponse.FAILURE_DEL_ENTITY;
import static com.mass.core.utils.AjaxResponse.FAILURE_EDIT_ENTITY;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.news.model.NewInfo;
import com.mass.biz.news.service.NewsService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 新闻（图文类）信息公共controller</p>
 *
 * @author lile
 * @version 1.0.0
 * @date 2017/08/17
 */
@RestController
@RequestMapping(value="/news")
public class NewsController{


    private final static Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;
    
    @LogAop(menuName="新闻管理",operationDesc="查询",operationType="3")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public AjaxResponse list(NewInfo news, 
                             @RequestParam(value = "page") Integer pageIndex,
                             @RequestParam(value = "limit") Integer pageSize){
        try {
            List<NewInfo> page = newsService.selectPageList(news, pageIndex, pageSize);
            return AjaxResponse.success("ok",page);
        }catch (Exception e){
        	e.printStackTrace();
            LOGGER.error("select NewsInfo error!", e);
            return null;
        }
    }  
    
    /**
     * 添加新闻
     * @param newsInfo
     */
    @LogAop(menuName="新闻管理",operationDesc="新增",operationType="1")
    @RequestMapping(value="/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(NewInfo news, HttpSession session){
       
            return null == this.newsService.addEntity(news) 
            		? new AjaxResponse(FAILURE_ADD_ENTITY, "error", news) : AjaxResponse.success("ok", news);
        
    }
    
    /**
     * 获取详情
     * @param id  对象id
     * @return
     */
    @LogAop(menuName="新闻管理",operationDesc="查询",operationType="3")
    @RequestMapping(value="/getEntityById", method = RequestMethod.GET)
    public AjaxResponse getEntityById(@RequestParam("id") Long id){
        try {
        	NewInfo News = this.newsService.getEntityById(id);
            return AjaxResponse.success("ok", News);
        }catch (Exception e){
        	e.printStackTrace();
            LOGGER.error("select News error!", e);
            return AjaxResponse.error("error");
        }
    }
    
    /**
     * 修改新闻信息
     * @param id  该新闻信息id
     * @return
     */
    @LogAop(menuName="新闻管理",operationDesc="修改",operationType="2")
    @RequestMapping(value="/editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(NewInfo news, HttpSession session){
            return this.newsService.editEntity(news) ? AjaxResponse.success("ok", news)
            		: new AjaxResponse(FAILURE_EDIT_ENTITY, "error", news);
    }
    
    /**
     * 删除新闻（支持批量删除）
     * @param id  
     * @return 
     */
    @LogAop(menuName="新闻管理",operationDesc="删除",operationType="4")
    @RequestMapping(value="/deleteEntity", method = RequestMethod.GET)
    public AjaxResponse deleteEntity(@RequestParam("id") String id){
        try {
            return this.newsService.deleteEntity(id) ? AjaxResponse.success("ok", id)
            		: new AjaxResponse(FAILURE_DEL_ENTITY, "error", id);
        }catch (Exception e){
        	e.printStackTrace();
            LOGGER.error("delete NewsInfo error!", e);
            return AjaxResponse.error("error");
        }
    }
    
    /**
     * 发布新闻(支持批量发布)
     * @param  id   
     * return 
     */
    @LogAop(menuName="新闻管理",operationDesc="发布",operationType="6")
    @RequestMapping(value="/publish", method = RequestMethod.POST)
    public AjaxResponse publish(@RequestParam("id") String id, HttpSession session){
        try {
        	/*SysUser userMain=(SysUser)session.getAttribute(LOGIN_USER_KEY);   //当前用户信息	
            return this.newsService.publish(id, userMain.getId(), userMain.getAccount()) 
            		? AjaxResponse.success("ok", id) : AjaxResponse.error("error", id);*/
        	return null;
        }catch (Exception e){
        	e.printStackTrace();
            LOGGER.error("publish News error!", e);
            return AjaxResponse.error("error");
        }
    }
    
    /**
     * 撤回发布
     * @param id 该新闻信息id
     * @return
     */
    @LogAop(menuName="新闻管理",operationDesc="撤销",operationType="6")
    @RequestMapping(value="/recall", method = RequestMethod.POST)
    public AjaxResponse recall(@RequestParam("id") String id){
        try {
            return this.newsService.recall(id) 
            		? AjaxResponse.success("ok", id) : AjaxResponse.error("error", id);
        }catch (Exception e){
        	e.printStackTrace();
            LOGGER.error("recall News error!", e);
            return AjaxResponse.error("error");
        }
    }
}
