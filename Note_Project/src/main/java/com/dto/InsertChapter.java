package com.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("InsertChapter")
public class InsertChapter {

	private int chIdx;
	private int ntIdx;
	private int chIncrease;
	private String chTitle;
	private String chContent;
	private String chMapInfo;
	private Date chTravelDate;
	
	public InsertChapter() { }
	public InsertChapter(int chIdx, int ntIdx, int chIncrease, String chTitle, String chContent, String chMapInfo, Date chTravelDate) {
		this.chIdx = chIdx;
		this.ntIdx = ntIdx;
		this.chIncrease = chIncrease;
		this.chTitle = chTitle;
		this.chContent = chContent;
		this.chMapInfo = chMapInfo;
		this.chTravelDate = chTravelDate;
	}
	
	public int getChIdx() {
		return chIdx;
	}
	public void setChIdx(int chIdx) {
		this.chIdx = chIdx;
	}
	public int getNtIdx() {
		return ntIdx;
	}
	public void setNtIdx(int ntIdx) {
		this.ntIdx = ntIdx;
	}
	public int getChIncrease() {
		return chIncrease;
	}
	public void setChIncrease(int chIncrease) {
		this.chIncrease = chIncrease;
	}
	public String getChTitle() {
		return chTitle;
	}
	public void setChTitle(String chTitle) {
		this.chTitle = chTitle;
	}
	public String getChContent() {
		return chContent;
	}
	public void setChContent(String chContent) {
		this.chContent = chContent;
	}
	public String getChMapInfo() {
		return chMapInfo;
	}
	public void setChMapInfo(String chMapInfo) {
		this.chMapInfo = chMapInfo;
	}
	public Date getChTravelDate() {
		return chTravelDate;
	}
	public void setChTravelDate(Date chTravelDate) {
		this.chTravelDate = chTravelDate;
	}
	
	
}
