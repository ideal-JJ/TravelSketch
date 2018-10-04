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
	
	

	public Note() { }

	public Note(int ntIdx, int uuId, String userName, String uPhoto, String ntTitle, Date ntDate, int chIdx,
			String chTitle, Date chTravelDate, String pctImgs) {
		super();
		this.ntIdx = ntIdx;
		this.uuId = uuId;
		this.userName = userName;
		this.uPhoto = uPhoto;
		this.ntTitle = ntTitle;
		this.ntDate = ntDate;
		this.chIdx = chIdx;
		this.chTitle = chTitle;
		this.chTravelDate = chTravelDate;
		this.pctImgs = pctImgs;
	}

	public int getNtIdx() {
		return ntIdx;
	}

	public void setNtIdx(int ntIdx) {
		this.ntIdx = ntIdx;
	}

	public int getUuId() {
		return uuId;
	}

	public void setUuId(int uuId) {
		this.uuId = uuId;
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

	public int getChIdx() {
		return chIdx;
	}

	public void setChIdx(int chIdx) {
		this.chIdx = chIdx;
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
	
	
	
	
}
