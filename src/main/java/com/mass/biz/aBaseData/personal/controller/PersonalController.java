package com.mass.biz.aBaseData.personal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.aBaseData.personal.model.Personal;
import com.mass.biz.aBaseData.personal.service.PersonalService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;

/**
 * 人员基础信息controller</p>
 * created on 2017/10/07
 * 
 */
@RestController
@RequestMapping(value = "/base/personal")
public class PersonalController{

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalController.class);

    @Autowired
    private PersonalService personalService;
  
    /**
     * 根据idCard查询某职工的基础信息
     * @param idcard 身份证号
     * @return
     */
    @LogAop(menuName="职工个人基础信息",operationDesc="查询",operationType="3")
    @RequestMapping(value = "/getEntityByIdCard", method = RequestMethod.GET)
    public AjaxResponse getEntityByIdCard(@RequestParam(value = "idcard") String idcard){
        try {
        	Personal personalBase = this.personalService.getEntityByIdcard(idcard);
            return AjaxResponse.success("ok", personalBase);
        } catch (Exception e) {
            LOGGER.error("get personalBase error!", e);
            return AjaxResponse.error("error", idcard);
        }
    }

    
    /**
     * 根据id查询某职工的基础信息
     * @param id 主键ID
     * @return
     */
    @LogAop(menuName="职工个人基础信息",operationDesc="查询",operationType="3")
    @RequestMapping(value = "/getEntityById", method = RequestMethod.GET)
    public AjaxResponse getEntityById(@RequestParam(value = "id") Long id){
        try {
        	Personal personalBase = this.personalService.getEntityById(id);
            return AjaxResponse.success("ok", personalBase);
        } catch (Exception e) {
            LOGGER.error("get personalBase error!", e);
            return AjaxResponse.error("error", id);
        }
    }
    
   
    /**
     * 通过parentId查询该职工的家庭成员信息列表
     * @param parentId  
     * @return
     */
    @LogAop(menuName="职工个人基础信息",operationDesc="查询",operationType="3")
    @RequestMapping(value = "/getEntityByParentId", method = RequestMethod.GET)
    public AjaxResponse getEntityByParentId(@RequestParam(value = "parentId") Long parentId){
        try {
        	List<Personal> personalBase = this.personalService.getEntityByParentId(parentId);
            return AjaxResponse.success("ok", personalBase);
        } catch (Exception e) {
            LOGGER.error("get personalBase error!", e);
            return AjaxResponse.error("error", parentId);
        }
    }
    
    /**
     * 验证身份证唯一
     * @param  idcard  身份证号码
     */
    @RequestMapping(value="/checkIdCardIsExist",method=RequestMethod.POST)
    public boolean checkUnitNameIsExist(@RequestParam(value="idcard") String idcard){
    	return this.personalService.checkIdCardIsExist(idcard);
    }
    
}
