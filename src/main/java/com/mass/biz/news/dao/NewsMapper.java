package com.mass.biz.news.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mass.biz.news.model.NewInfo;

/**
 * 新闻信息dao</p>
 *
 * @author lile
 * @version 1.0.0
 * @date 2017/08/17
 */
@Mapper
public interface NewsMapper{
	
	/**
     * 新增一条记录到数据库中.
     *
     * @param param     要新增的数据
     * @return  数据库更新结果
     */
    int insert(NewInfo param);
    

    /**
     * 统计总的记录数.一般情况是单表语句，查询条件为传进来的对象.
     *
     * @param params        查询条件
     * @return  总记录数据
     */
    long count(NewInfo params);

    /**
     * 分页查询。一般情况是单表分页，查询条件为传进来的对象.
     *
     * @param params    查询条件
     * @param offset    偏移量
     * @param limit     查询的数据量
     * @return  分页结果集合
     */
    List<NewInfo> selectPageList(@Param("searchParams") NewInfo params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 个体对象查询。一般情况是单表语句，查询条件为传进来的对象.
     * @param id     查询条件
     * @return  实体对象
     */
    NewInfo getEntityById(@Param("id")Long id);
    
    /**
     * 更新一条记录.
     *
     * @param param     要更新的记录
     * @return  更新结果
     */
    int update(NewInfo param);
    

    /**
     * 根据ID删除一条记录.
     *
     * @param id    要删除的记录ID
     * @return  删除的结果
     */
    int delete(@Param("id") Long id);
	/**
     * 发布新闻
     * @param  id    该新闻信息id
     * @param  publishId  发布人id
     * @param  publisher  发布人姓名
     */
	int publish(@Param("id")Long id, @Param("publishId")Long publishId, @Param("publisher")String publisher);
	
	/**
     * 撤回发布
     * @param  id    该新闻信息id
     */
    int recall(@Param("id")Long id);
    
    
    /**
	 * 根据id查询发布状态
	 * @param id
	 * @return
	 */
	int getIsPublishById(@Param("id") Long id);
	
	/**
     * 浏览是自动加1;
     *
     * @param param     要更新的记录
     * @return  更新结果
     */
    int updateClickRate(@Param("id") Long id);
}
