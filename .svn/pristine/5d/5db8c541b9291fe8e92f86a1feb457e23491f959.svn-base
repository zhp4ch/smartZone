package com.mass.biz.smart.services.Increment.controller;

import com.mass.biz.news.controller.NewsController;
import com.mass.biz.smart.services.Increment.model.Increment;
import com.mass.biz.smart.services.Increment.service.IncrementService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.core.utils.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName
 * @Author 郑上进
 * @Date 2018/8/21 14:23
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/wx/increment")
public class WxIncrementController {

    private final static Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private IncrementService incrementService;
    @Autowired
    private SzUserService szUserService;

    /**
     * @Name 列表及条件查询
     * @Param page, limit
     * @Author 郑上进
     * @Date 15:59 2018/8/7
     **/
    @RequestMapping(value = "/wx_selectPageList", method = RequestMethod.GET)
    public AjaxResponse selectPageList(Increment increment,
                                       @RequestParam(value = "page") Integer pageIndex,
                                       @RequestParam(value = "limit") Integer pageSize) {
        try {
            Long count = incrementService.count(increment);
            List<Increment> list = incrementService.selectPageList(increment, (pageIndex - 1) * pageSize, pageSize);
            return AjaxResponse.success("ok", list, count, pageIndex);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select incre error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * @Name 微信用 -新增服务
     * @Param object
     * @Author 郑上进
     * @Date 10:32 2018/8/10
     **/
    @RequestMapping(value = "/wx_addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(Increment increment) {
        try {
            this.incrementService.addEntity(increment);
            return AjaxResponse.success("ok", 0);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("inster incre error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * @Name 修改数据
     * @Param object
     * @Author 郑上进
     * @Date 15:52 2018/8/13
     **/
    @RequestMapping(value = "/wx_editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(Increment increment) {
        try {
            this.incrementService.editEntity(increment);
            if( increment.getIncrementState().intValue()==1) {
            	Increment  increment2 =incrementService.getEntityById(increment.getId());
            	SzUser zUser = szUserService.getEntityById(increment2.getApplyUserId());
            	szUserService.sendWXMessage(zUser.getOpen_id(), "您的增值服务申请已处理,感谢您提出宝贵的议建!");
            }
            return AjaxResponse.success("ok", 0);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("update incre error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * @Name 删除数据
     * @Param id
     * @Author 郑上进
     * @Date 16:25 2018/8/13
     **/

    @RequestMapping(value = "/wx_deleteEntity", method = RequestMethod.POST)
    public AjaxResponse deleteEntity(Long id) {
        try {
            this.incrementService.deleteEntity(id);
            return AjaxResponse.success("ok", 0);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("update incre error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * @Name 根据用户id查询所有申请的增值服务
     * @Param applyUserId
     * @Author 郑上进
     * @Date 11:06 2018/8/17
     **/
    @RequestMapping(value = "/wx_getEntityByUserId", method = RequestMethod.POST)
    public AjaxResponse getEntityByUserId(Long applyUserId) {
        try {
            List<Increment> incrementList = this.incrementService.getEntityByUserId(applyUserId);
            return AjaxResponse.success("ok", incrementList);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select incre error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * @Name 根据用户id和id查询单条增值服务详情
     * @Param object
     * @Author 郑上进
     * @Date 14:28 2018/8/17
     **/
    @RequestMapping(value = "/wx_getByIdByUserId", method = RequestMethod.POST)
    public AjaxResponse getByIdByUserId(Increment increment) {
        try {
            Increment increment1 =this.incrementService.getByIdByUserId(increment);
            return AjaxResponse.success("ok", increment1);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select incre error!", e);
            return AjaxResponse.error("error");
        }
    }






}
