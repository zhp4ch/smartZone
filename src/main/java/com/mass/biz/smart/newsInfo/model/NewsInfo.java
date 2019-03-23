package com.mass.biz.smart.newsInfo.model;

import java.util.Date;

/**
 * 新闻实体类
 * @author 
 * @date 2018-07-17
 *
 */
public class NewsInfo {
	
		private Long id;  //主键
	
		private String newsTitle;  	//新闻标题
		
		private String newsPicture; //新闻图片路径
		
		private Integer markType; 	//标记类型    
		
		private String newsContent; //新闻内容
		
		private String author;   	//作者
		
		private String newSource;	//新闻来源
		
		private String sourceName;	//数据来源地区
		
		private Integer isPublish;  //是否发布（1=是，0=否）
		
		private String publishTime;  	//发布时间
		
		private Long publishId;     //发布人ID
		
		private String publisher;   //发布人姓名
		
		private Integer topStatus;    //置顶状态（0=顶，1=推，2=精，3=普通）
		
		private Integer isOriginal;    ////是否原创 （1=是，0=否）
		
		private Integer clickRate;  //点击量   
		
		private Long createId;      //创建人ID
		
		private String creater;     //创建人
		
		private Long updateId;      //最后修改人ID
		
		private String updater;     //最后修改人
		
		private String createTime;   //创建时间
		
		private String updateTime;   //更新时间
		
		private Integer delFlag;     //删除标识
		
		private Date publishTimeBefore;  //查询发布起始时间
		
	    private Date publishTimeAfter;  //查询发布截止时间
	    
	    private Long fileInfoId;  //文件信息ID

		public Long getFileInfoId() {
			return fileInfoId;
		}

		public void setFileInfoId(Long fileInfoId) {
			this.fileInfoId = fileInfoId;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNewsTitle() {
			return newsTitle;
		}

		public void setNewsTitle(String newsTitle) {
			this.newsTitle = newsTitle;
		}

		public String getNewsPicture() {
			return newsPicture;
		}

		public void setNewsPicture(String newsPicture) {
			this.newsPicture = newsPicture;
		}

		public Integer getMarkType() {
			return markType;
		}

		public void setMarkType(Integer markType) {
			this.markType = markType;
		}

		public String getNewsContent() {
			return newsContent;
		}

		public void setNewsContent(String newsContent) {
			this.newsContent = newsContent;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getNewSource() {
			return newSource;
		}

		public void setNewSource(String newSource) {
			this.newSource = newSource;
		}

		public String getSourceName() {
			return sourceName;
		}

		public void setSourceName(String sourceName) {
			this.sourceName = sourceName;
		}

		public Integer getIsPublish() {
			return isPublish;
		}

		public void setIsPublish(Integer isPublish) {
			this.isPublish = isPublish;
		}

		public String getPublishTime() {
			return publishTime;
		}

		public void setPublishTime(String publishTime) {
			this.publishTime = publishTime;
		}

		public Long getPublishId() {
			return publishId;
		}

		public void setPublishId(Long publishId) {
			this.publishId = publishId;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public Integer getTopStatus() {
			return topStatus;
		}

		public void setTopStatus(Integer topStatus) {
			this.topStatus = topStatus;
		}

		public Integer getIsOriginal() {
			return isOriginal;
		}

		public void setIsOriginal(Integer isOriginal) {
			this.isOriginal = isOriginal;
		}

		public Integer getClickRate() {
			return clickRate;
		}

		public void setClickRate(Integer clickRate) {
			this.clickRate = clickRate;
		}

		public Long getCreateId() {
			return createId;
		}

		public void setCreateId(Long createId) {
			this.createId = createId;
		}

		public String getCreater() {
			return creater;
		}

		public void setCreater(String creater) {
			this.creater = creater;
		}

		public Long getUpdateId() {
			return updateId;
		}

		public void setUpdateId(Long updateId) {
			this.updateId = updateId;
		}

		public String getUpdater() {
			return updater;
		}

		public void setUpdater(String updater) {
			this.updater = updater;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public String getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}

		public Integer getDelFlag() {
			return delFlag;
		}

		public void setDelFlag(Integer delFlag) {
			this.delFlag = delFlag;
		}

		public Date getPublishTimeBefore() {
			return publishTimeBefore;
		}

		public void setPublishTimeBefore(Date publishTimeBefore) {
			this.publishTimeBefore = publishTimeBefore;
		}

		public Date getPublishTimeAfter() {
			return publishTimeAfter;
		}

		public void setPublishTimeAfter(Date publishTimeAfter) {
			this.publishTimeAfter = publishTimeAfter;
		}
	    
	    
}
