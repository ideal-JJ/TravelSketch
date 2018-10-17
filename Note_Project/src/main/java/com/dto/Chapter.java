package com.dto;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.ibatis.type.Alias;

/*
 * ch_idx as chIdx, ch_nt_idx as ch_ntIdx, ch_title as chTitle, 
   ch_content as chContent, ch_mapinfo as chMapInfo, CH_TRAVELDATE as chTravelDate
 * 
 */

@Alias("Chapter")
public class Chapter {
	private int chIdx;
	private int chIncrease;
	private String chTitle;
	private String chContent;
	private String chMapInfo;
	private Date chTravelDate;
	private String chImgs;
	
	
	public Chapter() {}

//	public Chapter(int chIdx, int chIncrease, String chTitle, String chContent, String chMapInfo, Date chTravelDate,
//			String chImgs) {
//		super();
//		this.chIdx = chIdx;
//		this.chIncrease = chIncrease;
//		this.chTitle = chTitle;
//		this.chContent = chContent;
//		this.chMapInfo = chMapInfo;
//		this.chTravelDate = chTravelDate;
//		this.chImgs = chImgs;
//	}

	public int getChIdx() {
		return chIdx;
	}

	public void setChIdx(int chIdx) {
		this.chIdx = chIdx;
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

	public String getChImgs() {
		return chImgs;
	}

	public void setChImgs(String chImgs) {
		this.chImgs = chImgs;
	}

	

	
}
