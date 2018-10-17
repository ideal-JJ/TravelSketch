package com.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/*
 * rp.RP_UM_ID as uuid, rp.rp_reply as reply, rp.rp_date as rpDate, 
   um.UM_NAME as uName, um.um_photo as uPhoto
 */
@Alias("Reply")
public class Reply {
	
	private int uuid;
	
	private String reply;
	private Date rpDate;
	
	private String uName;
	private String uPhoto;
	
	public Reply() {
	}
	public Reply(int uuid, String reply, Date rpDate, String uName, String uPhoto) {
		super();
		this.uuid = uuid;
		this.reply = reply;
		this.rpDate = rpDate;
		this.uName = uName;
		this.uPhoto = uPhoto;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getRpDate() {
		return rpDate;
	}
	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPhoto() {
		return uPhoto;
	}
	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}
	
	

	
}
