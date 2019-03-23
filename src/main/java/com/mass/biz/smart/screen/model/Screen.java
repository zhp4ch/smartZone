/*
*
* Screen.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-07-19
*/
package com.mass.biz.smart.screen.model;

import java.util.Date;

public class Screen {
    /**
     * 主键
     */
    private Long id;

    /**
     * 入驻数量
     */
    private Integer enterNum;

    /**
     * 园区图片
     */
    private String parkPicture;

    /**
     * 图片说明
     */
    private String pictureExplain;

    /**
     * 上一年
     */
    private String lastYear;

    /**
     * 当年
     */
    private String thisYear;

    /**
     * 园区编号
     */
    private String parkNum;

    /**
     * 园区名称
     */
    private String name;

    /**
     * 大屏看展标题
     */
    private String screenName;

    /**
     * 1月
     */
    private Integer january;

    /**
     * 2月
     */
    private Integer february;

    /**
     * 3月
     */
    private Integer march;

    /**
     * 4月
     */
    private Integer april;

    /**
     * 5月
     */
    private Integer may;

    /**
     * 6月
     */
    private Integer june;

    /**
     * 7月
     */
    private Integer july;

    /**
     * 8月
     */
    private Integer august;

    /**
     * 9月
     */
    private Integer september;

    /**
     * 10月
     */
    private Integer october;

    /**
     * 11月
     */
    private Integer november;

    /**
     * 12月
     */
    private Integer december;

    /**
     * 
     */
    private Byte delFlag;

    /**
     * 
     */
    private Date createTime;
    
    /**
     * 销售总数
     */
    private Integer saleNum;

    /**
     * 主键
     * @return ID 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 入驻数量
     * @return ENTER_NUM 入驻数量
     */
    public Integer getEnterNum() {
        return enterNum;
    }

    /**
     * 入驻数量
     * @param enterNum 入驻数量
     */
    public void setEnterNum(Integer enterNum) {
        this.enterNum = enterNum;
    }

    /**
     * 园区图片
     * @return PARK_PICTURE 园区图片
     */
    public String getParkPicture() {
        return parkPicture;
    }

    /**
     * 园区图片
     * @param parkPicture 园区图片
     */
    public void setParkPicture(String parkPicture) {
        this.parkPicture = parkPicture == null ? null : parkPicture.trim();
    }

    /**
     * 图片说明
     * @return PICTURE_EXPLAIN 图片说明
     */
    public String getPictureExplain() {
        return pictureExplain;
    }

    /**
     * 图片说明
     * @param pictureExplain 图片说明
     */
    public void setPictureExplain(String pictureExplain) {
        this.pictureExplain = pictureExplain == null ? null : pictureExplain.trim();
    }

    /**
     * 上一年
     * @return LAST_YEAR 上一年
     */
    public String getLastYear() {
        return lastYear;
    }

    /**
     * 上一年
     * @param lastYear 上一年
     */
    public void setLastYear(String lastYear) {
        this.lastYear = lastYear;
    }

    /**
     * 当年
     * @return THIS_YEAR 当年
     */
    public String getThisYear() {
        return thisYear;
    }

    /**
     * 当年
     * @param thisYear 当年
     */
    public void setThisYear(String thisYear) {
        this.thisYear = thisYear;
    }

    /**
     * 园区编号
     * @return PARK_NUM 园区编号
     */
    public String getParkNum() {
        return parkNum;
    }

    /**
     * 园区编号
     * @param parkNum 园区编号
     */
    public void setParkNum(String parkNum) {
        this.parkNum = parkNum == null ? null : parkNum.trim();
    }

    /**
     * 园区名称
     * @return NAME 园区名称
     */
    public String getName() {
        return name;
    }

    /**
     * 园区名称
     * @param name 园区名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 大屏看展标题
     * @return SCREEN_NAME 大屏看展标题
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * 大屏看展标题
     * @param screenName 大屏看展标题
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName == null ? null : screenName.trim();
    }

    /**
     * 1月
     * @return JANUARY 1月
     */
    public Integer getJanuary() {
        return january;
    }

    /**
     * 1月
     * @param january 1月
     */
    public void setJanuary(Integer january) {
        this.january = january;
    }

    /**
     * 2月
     * @return FEBRUARY 2月
     */
    public Integer getFebruary() {
        return february;
    }

    /**
     * 2月
     * @param february 2月
     */
    public void setFebruary(Integer february) {
        this.february = february;
    }

    /**
     * 3月
     * @return MARCH 3月
     */
    public Integer getMarch() {
        return march;
    }

    /**
     * 3月
     * @param march 3月
     */
    public void setMarch(Integer march) {
        this.march = march;
    }

    /**
     * 4月
     * @return APRIL 4月
     */
    public Integer getApril() {
        return april;
    }

    /**
     * 4月
     * @param april 4月
     */
    public void setApril(Integer april) {
        this.april = april;
    }

    /**
     * 5月
     * @return MAY 5月
     */
    public Integer getMay() {
        return may;
    }

    /**
     * 5月
     * @param may 5月
     */
    public void setMay(Integer may) {
        this.may = may;
    }

    /**
     * 6月
     * @return JUNE 6月
     */
    public Integer getJune() {
        return june;
    }

    /**
     * 6月
     * @param june 6月
     */
    public void setJune(Integer june) {
        this.june = june;
    }

    /**
     * 7月
     * @return JULY 7月
     */
    public Integer getJuly() {
        return july;
    }

    /**
     * 7月
     * @param july 7月
     */
    public void setJuly(Integer july) {
        this.july = july;
    }

    /**
     * 8月
     * @return AUGUST 8月
     */
    public Integer getAugust() {
        return august;
    }

    /**
     * 8月
     * @param august 8月
     */
    public void setAugust(Integer august) {
        this.august = august;
    }

    /**
     * 9月
     * @return SEPTEMBER 9月
     */
    public Integer getSeptember() {
        return september;
    }

    /**
     * 9月
     * @param september 9月
     */
    public void setSeptember(Integer september) {
        this.september = september;
    }

    /**
     * 10月
     * @return OCTOBER 10月
     */
    public Integer getOctober() {
        return october;
    }

    /**
     * 10月
     * @param october 10月
     */
    public void setOctober(Integer october) {
        this.october = october;
    }

    /**
     * 11月
     * @return NOVEMBER 11月
     */
    public Integer getNovember() {
        return november;
    }

    /**
     * 11月
     * @param november 11月
     */
    public void setNovember(Integer november) {
        this.november = november;
    }

    /**
     * 12月
     * @return DECEMBER 12月
     */
    public Integer getDecember() {
        return december;
    }

    /**
     * 12月
     * @param december 12月
     */
    public void setDecember(Integer december) {
        this.december = december;
    }

    /**
     * 
     * @return DEL_FLAG 
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * 
     * @param delFlag 
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 
     * @return CREATE_TIME 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}
}