package com.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Note")
public class Note {
	private int ntIdx;
	private int chIdx;
	
	private String userName;
	private String uPhoto;
	private int uuId;
	
	private String ntTitle;
	private Date ntDate;
	
	private String chTitle;
	private Date chTravelDate;
	
	private String pctImgs;
	
	private int lkCnt;
	private int rpyCnt;
	
	public Note() { }
	public Note(int ntIdx, int chIdx, String userName, String uPhoto, int uuId, String ntTitle, Date ntDate,
			String chTitle, Date chTravelDate, String pctImgs, int lkCnt, int rpyCnt) {
		super();
		this.ntIdx = ntIdx;
		this.chIdx = chIdx;
		this.userName = userName;
		this.uPhoto = uPhoto;
		this.uuId = uuId;
		this.ntTitle = ntTitle;
		this.ntDate = ntDate;
		this.chTitle = chTitle;
		this.chTravelDate = chTravelDate;
		this.pctImgs = pctImgs;
		this.lkCnt = lkCnt;
		this.rpyCnt = rpyCnt;
	}
	
	public int getNtIdx() {
		return ntIdx;
	}
	public void setNtIdx(int ntIdx) {
		this.ntIdx = ntIdx;
	}
	public int getChIdx() {
		return chIdx;
	}
	public void setChIdx(int chIdx) {
		this.chIdx = chIdx;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getuPhoto() {
		return uPhoto;
	}
	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}
	public int getUuId() {
		return uuId;
	}
	public void setUuId(int uuId) {
		this.uuId = uuId;
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
	public String getChTitle() {
		return chTitle;
	}
	public void setChTitle(String chTitle) {
		this.chTitle = chTitle;
	}
	public Date getChTravelDate() {
		return chTravelDate;
	}
	public void setChTravelDate(Date chTravelDate) {
		this.chTravelDate = chTravelDate;
	}
	public String getPctImgs() {
		return pctImgs;
	}
	public void setPctImgs(String pctImgs) {
		this.pctImgs = pctImgs;
	}
	public int getLkCnt() {
		return lkCnt;
	}
	public void setLkCnt(int lkCnt) {
		this.lkCnt = lkCnt;
	}
	public int getRpyCnt() {
		return rpyCnt;
	}
	public void setRpyCnt(int rpyCnt) {
		this.rpyCnt = rpyCnt;
	}
	
	
	
}
