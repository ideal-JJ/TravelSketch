package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("InsertPicture")
public class InsertPicture {

	private int ntIdx;
	private int chIdx;
	private String img;
	
	public InsertPicture() { }
	public InsertPicture(int ntIdx, int chIdx, String img) {
		this.ntIdx = ntIdx;
		this.chIdx = chIdx;
		this.img = img;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
