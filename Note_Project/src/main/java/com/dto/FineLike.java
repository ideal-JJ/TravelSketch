package com.dto;

import org.apache.ibatis.type.Alias;

/*
 * fl.FL_UM_ID as uuid, um.um_photo as uPhoto
 */

@Alias("FineLike")
public class FineLike {
	
	private int uuid;
	private String uPhoto;
	
	public FineLike() {
	}
	public FineLike(int uuid, String uPhoto) {
		super();
		this.uuid = uuid;
		this.uPhoto = uPhoto;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getuPhoto() {
		return uPhoto;
	}
	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}
	
	

	
	
}
