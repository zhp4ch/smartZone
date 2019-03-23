package com.mass.biz.aBaseData.personal.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mass.biz.aBaseData.personal.model.Personal;

/**
 * 人员基础信息dao接口</p>
 */
@Mapper
public interface PersonalMapper{
	/**
     * 新增一条记录到数据库中.
     *
     * @param param     要新增的数据
     * @return  数据库更新结果
     */
    int insert(Personal param);
    

    /**
     * 统计总的记录数.一般情况是单表语句，查询条件为传进来的对象.
     *
     * @param params        查询条件
     * @return  总记录数据
     */
    long count(Personal params);

    /**
     * 分页查询。一般情况是单表分页，查询条件为传进来的对象.
     *
     * @param params    查询条件
     * @param offset    偏移量
     * @param limit     查询的数据量
     * @return  分页结果集合
     */
    List<Personal> selectPageList(@Param("searchParams") Personal params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 个体对象查询。一般情况是单表语句，查询条件为传进来的对象.
     * @param id     查询条件
     * @return  实体对象
     */
    Personal getEntityById(@Param("id")Long id);
    
    /**
     * 更新一条记录.
     *
     * @param param     要更新的记录
     * @return  更新结果
     */
    int update(Personal param);
    

    /**
     * 根据ID删除一条记录.
     *
     * @param id    要删除的记录ID
     * @return  删除的结果
     */
    int delete(@Param("id") Long id);
	
	//   通过身份证号查询
	Personal getEntityByIdcard(@Param(value = "idcard") String idcard);
	
    //  通过parentId查询该职工的家庭成员信息列表
	List<Personal> getEntityByParentId(@Param(value = "parentId") Long parentId);

    long getPersonalCount(@Param(value = "i")Integer i);

    long getPersonalCountByDate(@Param(value = "i")Integer i, @Param(value = "date") Date date);
}
