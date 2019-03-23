package com.mass.biz.smart.services.ConferenceRoom.service.impl;

import com.mass.biz.smart.services.ConferenceRoom.dao.RoomMapper;
import com.mass.biz.smart.services.ConferenceRoom.model.Room;
import com.mass.biz.smart.services.ConferenceRoom.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName 会议室管理
 * @Author 郑上进
 * @Date 2018/7/20 16:09
 * @Version 1.0
 **/
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    /*后台会议室管理*/
    /**
     * 列表及分页查询
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public List<Room> selectPageList(Room room, Integer pageIndex, Integer pageSize) {
        List<Room> list = roomMapper.selectPageList(room,pageIndex,pageSize);
        return list;
    }

    /**
     * 统计总条数
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public long count(Room room) {
        return this.roomMapper.count(room);
    }

    /**
     * 微信-查询所有可预约会议室
     * @Author 郑上进
     * @Date 14:56 2018/8/2
     **/
    @Override
    public List<Room> wx_selectEntity(Room room) {
        List<Room> list =this.roomMapper.wx_selectEntity(room);
        return list;
    }

    /**
     * 新增数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public Room addEntity(Room room) {
        boolean b = 0 <this.roomMapper.insert(room);
        return b ?room :null;
    }

    /**
     * 修改数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public boolean editEntity(Room room) {
        return 0<this.roomMapper.update(room);
    }

    /**
     * 根据id查询数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/
    @Override
    public Room getEntityById(Long id) {
        return this.roomMapper.getEntityById(id);
    }

    /**
     * 删除数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/
    @Override
    public boolean deleteEntity(Long id) {
        return 0<this.roomMapper.delete(id);
    }
}
