package com.mass.biz.aBaseData.personal.service;

import java.util.List;

import com.mass.biz.aBaseData.personal.model.Personal;

/**
 * 职工会员基础信息service接口</p>
 * created by pannan on 2017/09/15
 * 
 */
public interface MemberService {
	/**
     * 列表及条件查询
     * @param  Personal     职工类信息
     * @param  pageIndex    页大小
     * @param  pageSize     页码
     */
    List<Personal> selectPageList(Personal basePersonal, Integer pageIndex, Integer pageSize) ;

    /**
     * 查询单条职工信息
     * @param id 主键ID
     */
    Personal getEntityById(Long id);

    /**
     * 添加职工信息数据
     * @param basePersonal 职工信息
     */
    Personal addEntity(Personal basePersonal);

    /**
     * 修改职工信息
     * @param basePersonal 职工信息
     */
    boolean editEntity(Personal basePersonal);

    /**
     * 删除职工信息
     * @param id 主键ID
     */
    boolean deleteEntity(Long id);

}
