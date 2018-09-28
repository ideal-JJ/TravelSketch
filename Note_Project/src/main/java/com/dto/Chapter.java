package com.dto;

import java.util.Date;

public class Chapter {
	private int chIdx;
	private int chIncrease;
	private String chTitle;
	private Date chTravelDate;
	
	public Chapter() {}

	public Chapter(int chIdx, int chIncrease, String chTitle, Date chTravelDate) {
		super();
		this.chIdx = chIdx;
		this.chIncrease = chIncrease;
		this.chTitle = chTitle;
		this.chTravelDate = chTravelDate;
	}

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

	public Date getChTravelDate() {
		return chTravelDate;
	}

	public void setChTravelDate(Date chTravelDate) {
		this.chTravelDate = chTravelDate;
	}
	
	
	
	
}
