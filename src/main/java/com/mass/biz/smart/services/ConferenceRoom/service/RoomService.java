package com.mass.biz.smart.services.ConferenceRoom.service;

import com.mass.biz.smart.services.ConferenceRoom.model.Room;

import java.util.List;

/**
 * @ClassName
 * @Author 郑上进
 * @Date 2018/7/20 16:08
 * @Version 1.0
 **/
public interface RoomService {


    /*后台会议室管理*/
    /**
     * 列表及分页查询
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    List<Room> selectPageList(Room room, Integer pageIndex, Integer pageSize);

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

    Room addEntity(Room room);

    /**
     * 修改数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/

    boolean editEntity(Room room);

    /**
     * 根据id查询数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/

    Room getEntityById(Long id);

    /**
     * 删除数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/

    boolean deleteEntity(Long id);







}
