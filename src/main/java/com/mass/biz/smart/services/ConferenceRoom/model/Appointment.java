package com.mass.biz.smart.services.ConferenceRoom.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 会议室预约使用
 * @Author 郑上进
 * @Date 2018/7/24 9:18
 * @Version 1.0
 **/
public class Appointment implements Serializable {


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


    /*用户申请*/
    /**
     * 申请人id
     */
    private Long applyId;

    /**
     * 申请公司
     */
    private String applyCompany;

    /**
     * 联系方式
     */
    private String applyPhone;

    /**
     * 申请的会议室id
     */
    private Long aaplyRoomId;

    /**
     * 会议室使用时间-开始
     */
    private String useRoomStartTime;

    /**
     * 会议室使用时间-结束
     */
    private String useRoomEndTime;

    /**
     * 审核人
     */
    private Long examineId;

    /**
     * 审核状态（0.审核中，1.已通过，2.已驳回）
     */
    private Integer examineState;

    /**
     * 审核意见
     */
    private String examineContent;

    /**
     * 归还状态（0.待审，1.正常，2.异常）
     */
    private Integer returnState;

    /**
     * 有无坏损备注
     */
    private String badLossText;

    /**
     * 存档照片
     */
    private String FilePictureUrl;

    /**
     * 会议室名称
     */
    private String boardRoom;

    /**
     * 会议室人数
     */
    private Integer number;

    /**
     * 申请人用户名
     */
    private String userName;

    /**
     * 审核人用户名
     */
    private String examineName;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFilePictureUrl() {
        return FilePictureUrl;
    }

    public void setFilePictureUrl(String filePictureUrl) {
        FilePictureUrl = filePictureUrl;
    }

    public String getExamineContent() {
        return examineContent;
    }

    public void setExamineContent(String examineContent) {
        this.examineContent = examineContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExamineName() {
        return examineName;
    }

    public void setExamineName(String examineName) {
        this.examineName = examineName;
    }

    public String getUseRoomStartTime() {
        return useRoomStartTime;
    }

    public void setUseRoomStartTime(String useRoomStartTime) {
        this.useRoomStartTime = useRoomStartTime;
    }

    public String getUseRoomEndTime() {
        return useRoomEndTime;
    }

    public void setUseRoomEndTime(String useRoomEndTime) {
        this.useRoomEndTime = useRoomEndTime;
    }

    public Long getExamineId() {
        return examineId;
    }

    public void setExamineId(Long examineId) {
        this.examineId = examineId;
    }

    public String getBoardRoom() {
        return boardRoom;
    }

    public void setBoardRoom(String boardRoom) {
        this.boardRoom = boardRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getApplyCompany() {
        return applyCompany;
    }

    public void setApplyCompany(String applyCompany) {
        this.applyCompany = applyCompany;
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    public Long getAaplyRoomId() {
        return aaplyRoomId;
    }

    public void setAaplyRoomId(Long aaplyRoomId) {
        this.aaplyRoomId = aaplyRoomId;
    }

    public Integer getExamineState() {
        return examineState;
    }

    public void setExamineState(Integer examineState) {
        this.examineState = examineState;
    }

    public Integer getReturnState() {
        return returnState;
    }

    public void setReturnState(Integer returnState) {
        this.returnState = returnState;
    }

    public String getBadLossText() {
        return badLossText;
    }

    public void setBadLossText(String badLossText) {
        this.badLossText = badLossText;
    }
}
