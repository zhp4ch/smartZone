package com.mass.biz.aBaseData.personal.controller;

import static com.mass.core.utils.AjaxResponse.FAILURE_ADD_ENTITY;
import static com.mass.core.utils.AjaxResponse.FAILURE_DEL_ENTITY;
import static com.mass.core.utils.AjaxResponse.FAILURE_EDIT_ENTITY;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.aBaseData.personal.model.Personal;
import com.mass.biz.aBaseData.personal.service.MemberService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 职工会员基础信息管理controller</p>
 * created on 2017/09/15
 * 
 */
@RestController
@RequestMapping(value = "/base/member")
public class MemberController{

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    /**
     * 基层职工会员基础信息数据
     * @param basePersonal  会员基础信息对象
     * @param regionInfo 	地区
     * @param pageIndex		页下标
     * @param pageSize		每页显示数量
     * @return
     */
    @LogAop(menuName="基层职工会员基础信息数据",operationDesc="查询",operationType="3")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public AjaxResponse list(Personal basePersonal, 
			 				 @RequestParam(value = "regionInfo") String regionInfo,
                             @RequestParam(value = "pageIndex") Integer pageIndex,
                             @RequestParam(value = "pageSize") Integer pageSize){
        try {
    		if("00".equals(regionInfo.substring(2, 4))) {  //省级
    			basePersonal.setProvince(regionInfo);
    		} else if("00".equals(regionInfo.substring(4, 6))) {  //市级
    			basePersonal.setCity(regionInfo);
    		} else  {                                            //县区
    			basePersonal.setCounty(regionInfo.substring(0, 6));
    		}
            List<Personal> page = memberService.selectPageList(basePersonal, pageIndex, pageSize);
            return AjaxResponse.success("ok", page);
        } catch (Exception e){
        	e.printStackTrace();
            LOGGER.error("select Personal error!", e);
            return AjaxResponse.error("error");
        }
    }
    /**
     * 查询单条会员基础信息信息
     *@param id 主键ID
     */
    @LogAop(menuName="基层职工会员基础信息数据",operationDesc="查询",operationType="3")
    @RequestMapping(value="/getEntityById", method = RequestMethod.GET)
    public AjaxResponse getEntityById(@RequestParam(value="id") Long id){
        try {
            Personal getEntity = this.memberService.getEntityById(id);
            return AjaxResponse.success("ok", getEntity);
        }catch(Exception e){
            LOGGER.error("select Personal error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 添加会员基础信息信息
     *@param member 会员基础信息信息
     */
    @LogAop(menuName="基层职工会员基础信息数据",operationDesc="新增",operationType="1")
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(Personal member){
        try {
            member = this.memberService.addEntity(member);
            return null == member ? new AjaxResponse(FAILURE_ADD_ENTITY, "error", member) : AjaxResponse.success("ok", member);
        }catch(Exception e){
            LOGGER.error("add Personal error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 删除会员基础信息信息
     * @param id 主键ID
     */
    @LogAop(menuName="基层职工会员基础信息数据",operationDesc="删除",operationType="4")
    @RequestMapping(value="/deleteEntity", method = RequestMethod.POST)
    public AjaxResponse deleteEntity(@RequestParam(value="id") Long id){
        try {
            return this.memberService.deleteEntity(id)?AjaxResponse.success("ok",id): new AjaxResponse(FAILURE_DEL_ENTITY,"error",id);
        }catch(Exception e){
            LOGGER.error("delete Personal error",e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 修改会员基础信息信息
     *@param member 会员基础信息信息
     */
    @LogAop(menuName="基层职工会员基础信息数据",operationDesc="修改",operationType="2")
    @RequestMapping(value="/editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(Personal member){
        try {
            return this.memberService.editEntity(member) ? AjaxResponse.success("ok", member) : new AjaxResponse(FAILURE_EDIT_ENTITY, "error", member);
        }catch(Exception e){
            LOGGER.error("edit Personal error",e);
            return AjaxResponse.error("error",member);
        }
    }
}
