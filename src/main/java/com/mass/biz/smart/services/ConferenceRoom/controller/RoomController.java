package com.mass.biz.smart.services.ConferenceRoom.controller;

import com.mass.biz.news.controller.NewsController;
import com.mass.biz.smart.services.ConferenceRoom.model.Appointment;
import com.mass.biz.smart.services.ConferenceRoom.model.Room;
import com.mass.biz.smart.services.ConferenceRoom.service.AppointmentService;
import com.mass.biz.smart.services.ConferenceRoom.service.RoomService;
import com.mass.core.utils.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName
 * @Author 郑上进
 * @Date 2018/7/20 15:45
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/room")
public class RoomController {

    private final static Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private RoomService roomService;

    @Autowired
    private AppointmentService appointmentService;


    /*后台会议室管理*/

    /**
     * 列表及条件查询
     * @Author 郑上进
     * @Date 14:41 2018/7/23
     **/
    @RequestMapping(value = "/selectPageList", method = RequestMethod.GET)
    public AjaxResponse selectPageList(Room room,
                                       @RequestParam(value = "page") Integer pageIndex,
                                       @RequestParam(value = "limit") Integer pageSize) {
        try {
            Room room1 = new Room();
            Appointment appointment =new Appointment();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            List<Appointment> applist = appointmentService.selectEntity(appointment);
            if(applist.size()>0){
                System.out.println("这里是数组判断");
                System.out.println("=============");
                for(int i=0;i<applist.size();i++){
                    Appointment appointment1=applist.get(i);
                    String useRoomStartTime=appointment1.getUseRoomStartTime();
                    String useRoomEndTime=appointment1.getUseRoomEndTime();
                    Date a=format.parse(useRoomStartTime);
                    Date b=format.parse(useRoomEndTime);
                    Long c=System.currentTimeMillis();
                    System.out.println("这里是数组遍历");
                    System.out.println("这个是当前时间"+c);
                    System.out.println("这个是使用开始时间"+a.getTime());
                    System.out.println("这个是使用结束时间"+b.getTime());
                    System.out.println("=============");
                    //如果用户开始使用时间在当前时间之前并且结束使用时间在当前时间之后 则为正在使用
                    if(a.getTime()<c && b.getTime()>c){
                        room1.setId(appointment1.getAaplyRoomId());
                        room1.setUsageState(2);
                        roomService.editEntity(room1);
                        System.out.println("这里是修改方法-使用中");
                        //break;
                    }else if(a.getTime()<c && b.getTime()<c){
                        room1.setId(appointment1.getAaplyRoomId());
                        room1.setUsageState(0);
                        roomService.editEntity(room1);
                        System.out.println("这里是修改方法-结束使用");
                        //break;
                    }else if(a.getTime()>c && b.getTime()>c){
                        room1.setId(appointment1.getAaplyRoomId());
                        room1.setUsageState(1);
                        roomService.editEntity(room1);
                        System.out.println("这里是修改方法-预约中");
                    }
                }
            }
            Long count = roomService.count(room);
            List<Room> list = roomService.selectPageList(room, (pageIndex - 1) * pageSize, pageSize);
            return AjaxResponse.success("ok", list, count, pageIndex);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select sz error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * 微信-查询所有可预约会议室
     * @Author 郑上进
     * @Date 14:56 2018/8/2
     **/
    @RequestMapping(value = "/wx_selectEntity",method = RequestMethod.POST)
    public AjaxResponse wx_selectEntity(Room room){
        try {
            List<Room> roomList =this.roomService.wx_selectEntity(room);
            return AjaxResponse.success("ok",roomList);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("select room error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * 新增会议室
     * @Author 郑上进
     * @Date 10:50 2018/7/25
     **/
    @RequestMapping(value = "/addEntity",method = RequestMethod.POST)
    public AjaxResponse addEntity(Room room){
        try {
            this.roomService.addEntity(room);
            return AjaxResponse.success("ok",room);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("insert room error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * 修改会议室
     * @Author 郑上进
     * @Date 10:57 2018/7/25
     **/
    @RequestMapping(value = "/editEntity",method = RequestMethod.POST)
    public AjaxResponse editEntity(Room room){
        try {
            this.roomService.editEntity(room);
            return AjaxResponse.success("ok",room);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("update room error!",e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * 删除会议室
     * @Author 郑上进
     * @Date 10:57 2018/7/25
     **/
    @RequestMapping(value = "/deleteEntity",method = RequestMethod.POST)
    public AjaxResponse deleteEntity(Long id){
        try {
            this.roomService.deleteEntity(id);
            return AjaxResponse.success("ok",0);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("delete room error!",e);
            return AjaxResponse.error("error");
        }
    }


}
