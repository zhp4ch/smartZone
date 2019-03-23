package com.mass.biz.smart.services.ConferenceRoom.controller;

import com.mass.biz.news.controller.NewsController;
import com.mass.biz.smart.services.ConferenceRoom.model.Appointment;
import com.mass.biz.smart.services.ConferenceRoom.service.AppointmentService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.core.utils.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName
 * @Author 郑上进
 * @Date 2018/8/21 11:55
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/wx/appointment")
public class WxAppointmentController {


    private final static Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private SzUserService szUserService;


    /*--  后台  --*/
    /**
     * 列表及条件查询
     * @Author 郑上进
     * @Date 14:41 2018/7/23
     **/
    @RequestMapping(value = "/wx_selectPageList", method = RequestMethod.GET)
    public AjaxResponse selectPageList(Appointment appointment,
                                       @RequestParam(value = "page") Integer pageIndex,
                                       @RequestParam(value = "limit") Integer pageSize) {
        try {
            Long count = appointmentService.count(appointment);
            List<Appointment> list = appointmentService.selectPageList(appointment, (pageIndex - 1) * pageSize, pageSize);
            return AjaxResponse.success("ok", list, count, pageIndex);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select sz error!", e);
            return AjaxResponse.error("error");
        }
    }

    /*-- 微信 --*/
    /**
     * 微信-新增数据(用户申请会议室)
     * @Author 郑上进
     * @Date 14:41 2018/7/23
     **/
    @RequestMapping(value = "/wx_addEntity", method = RequestMethod.POST)
    public AjaxResponse wx_addEntity(Appointment appointment) {
        try {
            this.appointmentService.wx_addEntity(appointment);
            return AjaxResponse.success("ok",appointment);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("inster sz error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 微信-查询用户全部预约
     * @Author 郑上进
     * @Date 16:07 2018/8/2
     **/
    @RequestMapping(value = "/wx_selectUserEntity", method = RequestMethod.POST)
    public AjaxResponse wx_selectUserEntity(Appointment appointment) {
        try {
            List<Appointment> appointmentList = this.appointmentService.wx_selectUserEntity(appointment);
            return AjaxResponse.success("ok",appointmentList);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select sz error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * @Name 微信-查询单条预约详情
     * @Param applyId,applyRoomId
     * @Author
     * @Date 9:00 2018/8/15
     **/
    @RequestMapping(value = "/wx_selectByRoom", method = RequestMethod.POST)
    public AjaxResponse wx_selectByRoom(Appointment appointment) {
        try {
            Appointment appointment1 = this.appointmentService.wx_selectByRoom(appointment);
            return AjaxResponse.success("ok",appointment1);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select sz error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 修改数据
     * @Author 郑上进
     * @Date 14:41 2018/7/23
     **/
    @RequestMapping(value = "/wx_editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(Appointment appointment) {
        try {
            this.appointmentService.editEntity(appointment);
            Appointment applyRoom  = appointmentService.getEntityById(appointment.getId());
            if( appointment.getExamineState().intValue()==1) {
            	SzUser zUser = szUserService.getEntityById(appointment.getApplyId());
            	szUserService.sendWXMessage(zUser.getOpen_id(), "您的会议室申请审批已通过过\n"+"预约时间为:"+applyRoom.getUseRoomStartTime()+"-"+applyRoom.getUseRoomEndTime()+"!");
            }
            return AjaxResponse.success("ok",appointment);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("update sz error!", e);
            return AjaxResponse.error("error");
        }
    }








}
