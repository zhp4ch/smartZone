package com.mass.biz.smart.services.ConferenceRoom.dao;

import com.mass.biz.smart.services.ConferenceRoom.model.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName 会议室预约使用
 * @Author 郑上进
 * @Date 2018/7/24 9:18
 * @Version 1.0
 **/
@Mapper
public interface AppointmentMapper {

    /*后台会议室管理*/
    /**
     * 列表及分页查询
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    List<Appointment> selectPageList(@Param("searchParams") Appointment appointment,
                                     @Param("offset") Integer offset, @Param("limit") Integer limit);



    /**
     * 查询所有申请信息
     * @Author 郑上进
     * @Date 16:16 2018/8/1
     **/
    List<Appointment> selectEntity(Appointment appointment);

    /**
     * 统计总条数
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    long count(Appointment appointment);

    /**
     * 微信-新增数据(用户申请会议室)
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    int wx_insert(Appointment appointment);

    /**
     * 删除数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/

    int delete(@Param("id") Long id);


    /**
     * 微信-查询用户全部预约
     * @Author 郑上进
     * @Date 15:21 2018/8/2
     **/
    List<Appointment> wx_selectUserEntity(Appointment appointment);

    /**
     * @Name 微信-查询单条预约详情
     * @Param applyId,applyRoomId
     * @Author
     * @Date 9:00 2018/8/15
     **/
    Appointment wx_selectByRoom(Appointment appointment);

    /**
     * 修改数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    int update(Appointment appointment);

    /**
     * 根据id查询数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/

    Appointment getEntityById(@Param("id") Long id);




}
