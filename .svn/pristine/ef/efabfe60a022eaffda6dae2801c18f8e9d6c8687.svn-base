package com.mass.biz.smart.services.ConferenceRoom.controller;

import com.mass.biz.news.controller.NewsController;
import com.mass.biz.smart.services.ConferenceRoom.model.Appointment;
import com.mass.biz.smart.services.ConferenceRoom.service.AppointmentService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.biz.utils.PayCommonUtil;
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
 * @ClassName 会议室预约使用
 * @Author 郑上进
 * @Date 2018/7/24 9:19
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

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
    @RequestMapping(value = "/selectPageList", method = RequestMethod.GET)
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

    /**
     * 删除数据
     * @Author 郑上进
     * @Date 17:28 2018/7/26
     **/
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.GET)
    public AjaxResponse deleteEntity(Long id) {
        try {
            this.appointmentService.deleteEntity(id);
            return AjaxResponse.success("ok",0);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("delete sz error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 修改数据
     * @Author 郑上进
     * @Date 14:41 2018/7/23
     **/
    @RequestMapping(value = "/editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(Appointment appointment) {
        try {
            this.appointmentService.editEntity(appointment);
            Appointment applyRoom  = appointmentService.getEntityById(appointment.getId());
            if( appointment.getExamineState().intValue()==1) {
            	SzUser zUser = szUserService.getEntityById(applyRoom.getApplyId());
            	szUserService.sendWXMessage(zUser.getOpen_id(), "<a href = \""+PayCommonUtil.url+"/via.html?mold=myOffice\">"+"您的会议室审批已通过!</a>");
            }
            return AjaxResponse.success("ok",appointment);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("update sz error!", e);
            return AjaxResponse.error("error");
        }
    }


}
