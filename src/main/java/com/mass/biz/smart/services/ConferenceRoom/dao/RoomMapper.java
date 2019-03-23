package com.mass.biz.smart.services.ConferenceRoom.dao;

import com.mass.biz.smart.services.ConferenceRoom.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName 会议室管理
 * @Author 郑上进
 * @Date 2018/7/20 15:43
 * @Version 1.0
 **/
@Mapper
public interface RoomMapper {


    /*后台会议室管理*/
    /**
     * 列表及分页查询
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    List<Room> selectPageList(@Param("searchParams") Room room,
                              @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 统计总条数
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    long count(Room room);

    /**
     * 微信-查询所有可预约会议室
     * @Author 郑上进
     * @Date 14:56 2018/8/2
     **/
    List<Room> wx_selectEntity(Room room);

    /**
     * 新增数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    int insert(Room room);

    /**
     * 修改数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    int update(Room room);

    /**
     * 根据id查询数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/

    Room getEntityById(@Param("id") Long id);

    /**
     * 删除数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/

    int delete(@Param("id") Long id);




}
