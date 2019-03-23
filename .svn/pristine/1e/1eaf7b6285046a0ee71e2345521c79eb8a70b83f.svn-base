package com.mass.biz.smart.services.Contract.dao;

import com.mass.biz.smart.services.Contract.model.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName
 * @Author 郑上进
 * @Date 2018/8/7 9:54
 * @Version 1.0
 **/
@Mapper
public interface ContractMapper {


    /*后台管理*/

    /**
     * 列表及分页查询
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    List<Contract> selectPageList(@Param("searchParams") Contract contract,
                                  @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 统计总条数
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/

    long count(Contract contract);

    /**
     * 新增数据
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/

    int insert(Contract contract);

    /**
     * 修改数据
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/

    int update(Contract contract);

    /**
     * 根据id查询数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/

    Contract getEntityById(@Param("id") Long id);

    /**
     * 删除数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/

    int delete(@Param("id") Long id);

    /**
     * @Name 查询下载文件路径
     * @Param path
     * @Author 郑上进
     * @Date 18:20 2018/8/29
     **/
    Contract selectPath (String contractUrl);

    /*微信端*/

    /**
     * @Name 微信-根据公司id查询该用户租赁合同；
     * @Param companyId
     * @Author 郑上进
     * @Date 9:16 2018/8/13
     **/
     List<Contract> getCompanyIdByZn(@Param("companyId") Long companyId);

    /**
     * @Name 微信-根据公司id查询该用户所有其他类型合同
     * @Param companyId
     * @Author 郑上进
     * @Date 9:17 2018/8/13
     **/
     List<Contract> getCompanyIdByQt(@Param("companyId") Long companyId);


}
