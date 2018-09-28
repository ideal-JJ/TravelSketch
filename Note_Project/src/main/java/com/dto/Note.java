package com.dto;

import java.util.Date;

public class Note {
	private int ntIdx;
	private int userId;
	private String ntTitle;
	private Date ntDate;
	
	private Chapter chapter;
//	private Picture picture;
//	private Reply reply;
//	private FineLike finelike;
	
	public Note() { }
	public Note(int ntIdx, int userId, String ntTitle, Date ntDate, Chapter chapter) {	//, Picture picture, Reply reply, FineLike finelike) { 
		this.ntIdx = ntIdx;
		this.userId = userId;
		this.ntTitle = ntTitle;
		this.ntDate = ntDate;
		this.chapter = chapter;
//		this.picture = picture;
//		this.reply = reply;
//		this.finelike = finelike;
	}
	
	public int getNtIdx() {
		return ntIdx;
	}
	public void setNtIdx(int ntIdx) {
		this.ntIdx = ntIdx;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNtTitle() {
		return ntTitle;
	}
	public void setNtTitle(String ntTitle) {
		this.ntTitle = ntTitle;
	}
	public Date getNtDate() {
		return ntDate;
	}
	public void setNtDate(Date ntDate) {
		this.ntDate = ntDate;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
//	public Picture getPicture() {
//		return picture;
//	}
//	public void setPicture(Picture picture) {
//		this.picture = picture;
//	}
//	public Reply getReply() {
//		return reply;
//	}
//	public void setReply(Reply reply) {
//		this.reply = reply;
//	}
//	public FineLike getFinelike() {
//		return finelike;
//	}
//	public void setFinelike(FineLike finelike) {
//		this.finelike = finelike;
//	}
	
	
	
}
