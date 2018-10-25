package com.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("InsertNote")
public class InsertNote {
	
//	private int ntIdx;
	private int uuId;
	private String ntTitle;
	
	public InsertNote() { }
	public InsertNote(int uuId, String ntTitle) {
		this.uuId = uuId;
		this.ntTitle = ntTitle;
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
}
