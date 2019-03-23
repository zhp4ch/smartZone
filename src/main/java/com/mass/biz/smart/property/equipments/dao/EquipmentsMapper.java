/*
*
* EquipmentsMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-08-15
*/
package com.mass.biz.smart.property.equipments.dao;


import com.mass.biz.smart.property.equipments.model.Equipments;
import com.mass.biz.smart.property.equipments.model.EquipmentsExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EquipmentsMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(EquipmentsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(EquipmentsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long rid);

    /**
     *
     * @mbg.generated
     */
    int insert(Equipments record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Equipments record);

    /**
     *
     * @mbg.generated
     */
    List<Equipments> selectByExample(EquipmentsExample example);

    /**
     *
     * @mbg.generated
     */
    Equipments selectByPrimaryKey(Long rid);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Equipments record, @Param("example") EquipmentsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Equipments record, @Param("example") EquipmentsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Equipments record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Equipments record);
    /**
     * 批量插入数据
     * @param record
     * @return
     */
    int batchInsert(List<Equipments> record);
}