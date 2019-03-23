package com.mass.biz.smart.services.Increment.dao;

import com.mass.biz.smart.services.Increment.model.Increment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName 增值服务
 * @Author 郑上进
 * @Date 2018/8/13 14:20
 * @Version 1.0
 **/
@Mapper
public interface IncrementMapper {


    /**
     * 列表及分页查询
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    List<Increment> selectPageList(@Param("searchParams") Increment increment,
                                   @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 统计总条数
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/

    long count(Increment increment);

    /**
     * 修改数据
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/

    int update(Increment increment);

    /**
     * 根据id查询数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/

    Increment getEntityById(@Param("id") Long id);

    /**
     * 删除数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/

    int delete(@Param("id") Long id);


    /*微信端*/

    /**
     * 新增数据
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/

    int insert(Increment inContract);

    /**
     * @Name 根据用户id查询所有申请的增值服务
     * @Param applyUserId
     * @Author 郑上进
     * @Date 11:06 2018/8/17
     **/
    List<Increment> getEntityByUserId(@Param("applyUserId") Long applyUserId);
    
    /**
     * @Name 根据用户id和id查询单条增值服务详情
     * @Param object
     * @Author 郑上进
     * @Date 14:28 2018/8/17
     **/
    Increment getByIdByUserId(Increment increment);


}
