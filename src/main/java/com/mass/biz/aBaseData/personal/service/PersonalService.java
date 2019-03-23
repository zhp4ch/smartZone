package com.mass.biz.aBaseData.personal.service;

import com.mass.biz.aBaseData.personal.model.Personal;

import java.util.Date;
import java.util.List;


/**
 * 人员基础信息service接口类</p>
 *  created by pannan on 2017/10/07
 *  
 */
public interface PersonalService {

	 /**
     * 根据idcard获得职工个人信息
     */
    Personal getEntityByIdcard(String idcard);
    
    /**
     * 根据id获得职工个人信息
     */
    Personal getEntityById(Long id);
    
    /**
     * 通过parentId查询该职工的家庭成员信息列表
     */
    List<Personal> getEntityByParentId(Long parentId);
    
    /**
     * 验证身份证唯一
     * @param  idcard  身份证号码
     */
    boolean checkIdCardIsExist(String idcard);
    
    /**
     * 职工人数
     * @param i
     * @return
     */
    long getPersonalCount(Integer i);

    long getPersonalCountByDate(Integer i, Date date);
}
