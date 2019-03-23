package com.mass.biz.aBaseData.personal.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mass.biz.aBaseData.personal.dao.PersonalMapper;
import com.mass.biz.aBaseData.personal.model.Personal;
import com.mass.biz.aBaseData.personal.service.PersonalService;

/**
 * 人员基础信息service实现类</p>
 *  created by pannan on 2017/10/07
 *  
 */
@Service
public class PersonalServiceImpl implements PersonalService {

	@Autowired
    private PersonalMapper personalMapper;

	/**
     * 根据idcard获得职工个人信息
     */
    public Personal getEntityByIdcard(String idcard) {
    	return this.personalMapper.getEntityByIdcard(idcard);
    }

    /**
     * 根据id获得职工个人信息
     */
    public Personal getEntityById(Long id) {
    	return this.personalMapper.getEntityById(id);
    }
    
	/**
     * 通过parentId查询该职工的家庭成员信息列表
     */
    public List<Personal> getEntityByParentId(Long parentId) {
    	return this.personalMapper.getEntityByParentId(parentId);
    }
    
    
    /**
     * 验证身份证唯一
     * @param  idcard  身份证号码
     */
    public boolean checkIdCardIsExist(String idcard){
    	Personal personal=this.personalMapper.getEntityByIdcard(idcard);
        return null==personal;
    }
    
    public long getPersonalCount(Integer i){
        return personalMapper.getPersonalCount(i);
    }

    public long getPersonalCountByDate(Integer i, Date date) {
        return personalMapper.getPersonalCountByDate(i,date);
    }
}

