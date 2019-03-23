package com.mass.biz.smart.services.ConferenceRoom.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 会议室管理
 * @Author 郑上进
 * @Date 2018/7/20 15:43
 * @Version 1.0
 **/
public class Room implements Serializable {

    /*系统*/
    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除状态
     */
    private Integer delFlag;


    /*会议室管理*/
    /**
     * 会议室
     */
    private String boardRoom;

    /**
     * 容纳人数
     */
    private Integer ppeNumber;

    /**
     * 可用时间-开始
     */
    private String availableTimeBegin;

    /**
     * 可用时间-结束
     */
    private String availableTimeEnd;

    /**
     * 使用情况（0.空闲；1.已被预约；2.正在使用）
     */
    private Integer usageState;

    /**
     * 会议室状态(0禁用，1正常)
     */
    private Integer roomState;


    public Integer getRoomState() {
        return roomState;
    }

    public void setRoomState(Integer roomState) {
        this.roomState = roomState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getBoardRoom() {
        return boardRoom;
    }

    public void setBoardRoom(String boardRoom) {
        this.boardRoom = boardRoom;
    }

    public Integer getPpeNumber() {
        return ppeNumber;
    }

    public void setPpeNumber(Integer ppeNumber) {
        this.ppeNumber = ppeNumber;
    }

    public Integer getUsageState() {
        return usageState;
    }

    public void setUsageState(Integer usageState) {
        this.usageState = usageState;
    }

    public String getAvailableTimeBegin() {
        return availableTimeBegin;
    }

    public void setAvailableTimeBegin(String availableTimeBegin) {
        this.availableTimeBegin = availableTimeBegin;
    }

    public String getAvailableTimeEnd() {
        return availableTimeEnd;
    }

    public void setAvailableTimeEnd(String availableTimeEnd) {
        this.availableTimeEnd = availableTimeEnd;
    }
}
