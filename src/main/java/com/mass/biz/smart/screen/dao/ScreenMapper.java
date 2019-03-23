/*
*
* ScreenMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-07-19
*/
package com.mass.biz.smart.screen.dao;

import com.mass.biz.smart.screen.model.Screen;
import com.mass.biz.smart.screen.model.ScreenExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ScreenMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(ScreenExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(ScreenExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int insert(Screen record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Screen record);

    /**
     *
     * @mbg.generated
     */
    List<Screen> selectByExample(ScreenExample example);

    /**
     *
     * @mbg.generated
     */
    Screen selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Screen record, @Param("example") ScreenExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Screen record, @Param("example") ScreenExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Screen record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Screen record);
    
    //动态修改销售数据
    int updateTimer();
    
    //初始化销售数据为32w多
    int initSaleNum();
}