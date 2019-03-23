package com.mass.biz.smart.services.ConferenceRoom.service.impl;

import com.mass.biz.smart.services.ConferenceRoom.dao.AppointmentMapper;
import com.mass.biz.smart.services.ConferenceRoom.model.Appointment;
import com.mass.biz.smart.services.ConferenceRoom.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName 会议室预约使用
 * @Author 郑上进
 * @Date 2018/7/24 9:19
 * @Version 1.0
 **/
@Service
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    private  AppointmentMapper appointmentMapper;

    /*-- 后台 --*/
    /**
     * 列表及分页查询
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public List<Appointment> selectPageList(Appointment appointment, Integer pageIndex, Integer pageSize) {
       List<Appointment> list =appointmentMapper.selectPageList(appointment,pageIndex,pageSize);
       return list;
    }

    /**
     * 查询所有申请
     * @Author 郑上进
     * @Date 16:18 2018/8/1
     **/

    @Override
    public List<Appointment> selectEntity(Appointment appointment) {
        List<Appointment>list=appointmentMapper.selectEntity(appointment);
        return list;
    }

    /**
     * 统计总条数
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public long count(Appointment appointment) {
        return this.appointmentMapper.count(appointment);
    }

    /**
     * 删除数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/
    @Override
    public boolean deleteEntity(Long id) {
        return 0<this.appointmentMapper.delete(id);
    }


    /*-- 微信 --*/
    /**
     * 微信-新增数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public Appointment wx_addEntity(Appointment appointment) {
        boolean b = 0 <this.appointmentMapper.wx_insert(appointment);
        return b ? appointment :null;
    }

    /**
     * 微信-查询用户全部预约
     * @Author 郑上进
     * @Date 15:21 2018/8/2
     **/
    @Override
    public List<Appointment> wx_selectUserEntity(Appointment appointment) {
        List<Appointment> list =this.appointmentMapper.wx_selectUserEntity(appointment);
        return list;
    }

    /**
     * @Name 微信-查询单条预约详情
     * @Param applyId,applyRoomId
     * @Author
     * @Date 9:00 2018/8/15
     **/
    @Override
    public Appointment wx_selectByRoom(Appointment appointment) {
        return this.appointmentMapper.wx_selectByRoom(appointment);
    }

    /**
     * 根据id查询数据
     * @Author 郑上进
     * @Date 10:47 2018/7/23
     **/
    @Override
    public Appointment getEntityById(Long id) {
        return this.appointmentMapper.getEntityById(id);
    }

    /**
     * 修改数据
     * @Author 郑上进
     * @Date 10:46 2018/7/23
     **/
    @Override
    public boolean editEntity(Appointment appointment) {
        return 0<this.appointmentMapper.update(appointment);
    }







}
