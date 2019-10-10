package com.bds.tokenTest.test.xiaohongshu.model;

import java.util.Date;

public class NoteInfo {

	private Integer id;
	private String keyword;
	private String noteId;
	private String title;
	private String desc;
	private String noteTime;
	private String topicsJson;
	private String images;
	private String likedCount;
	private String collectedCount;
	private String commentsCount;
	private String sharedCount;
	private Date CreateTime;
	private Date CreateDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getNoteId() {
		return noteId;
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getNoteTime() {
		return noteTime;
	}
	public void setNoteTime(String noteTime) {
		this.noteTime = noteTime;
	}
	public String getTopicsJson() {
		return topicsJson;
	}
	public void setTopicsJson(String topicsJson) {
		this.topicsJson = topicsJson;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getLikedCount() {
		return likedCount;
	}
	public void setLikedCount(String likedCount) {
		this.likedCount = likedCount;
	}
	public String getCollectedCount() {
		return collectedCount;
	}
	public void setCollectedCount(String collectedCount) {
		this.collectedCount = collectedCount;
	}
	public String getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(String commentsCount) {
		this.commentsCount = commentsCount;
	}
	public String getSharedCount() {
		return sharedCount;
	}
	public void setSharedCount(String sharedCount) {
		this.sharedCount = sharedCount;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
}
