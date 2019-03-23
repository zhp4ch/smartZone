package com.mass.biz.aBaseData.personal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.aBaseData.personal.dao.MemberMapper;
import com.mass.biz.aBaseData.personal.model.Personal;
import com.mass.biz.aBaseData.personal.service.MemberService;

/**
 * 职工会员基础信息service实现类</p>
 * created by pannan on 2017/09/15
 * 
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper basePersonalMapper;


    /**
     * 列表及条件查询
     * @param  Personal    基础类信息
     * @param  pageIndex    页大小
     * @param  pageSize     页码
     */
    public List<Personal> selectPageList(Personal basePersonal, Integer pageIndex, Integer pageSize) {
    	List<Personal> page = basePersonalMapper.selectPageList(basePersonal, pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询单条会员基础信息
     * @param id 主键ID
     */
    public Personal getEntityById(Long id) {
    	return this.basePersonalMapper.getEntityById(id);
    }

    /**
     * 添加会员基础信息数据
     *@basePersonal 会员基础信息
     */
    public Personal addEntity(Personal basePersonal) {
    	return 0<this.basePersonalMapper.insert(basePersonal) ? basePersonal : null;
    }

    /**
     *修改会员基础信息数据
     * @basePersonal 会员基础信息
     */
    public boolean editEntity(Personal basePersonal) {
    	return 0<this.basePersonalMapper.update(basePersonal);
    }

    /**
     * 删除会员基础信息数据
     * @param id 主键ID
     */
    public boolean deleteEntity(Long id) {
    	return 0<this.basePersonalMapper.delete(id);
    }
}


