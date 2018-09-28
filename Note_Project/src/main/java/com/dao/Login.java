package com.dao;

import java.util.Date;

import org.apache.ibatis.type.Alias;

//UM_ID			uId
//UM_LOGINID	userId
//UM_PASSWD		passwd
//UM_NAME		uName
//UM_EMAIL		uEmail
//UM_TEL		uTel
//UM_DATE		uMakeDate
//UM_PHOTO		uPhoto
//UM_PHOTO_BG	uPhotoBg
//UM_SNS		umSns

@Alias("Login")
public class Login {
	private int uId;			// 유저ID(seq)
	private String userId;	// 유저 로그인 id
	private String passwd;
	private String uName;
	private String uEmail;
	private String uTel;
	private Date uJoinDate;		// 회원가입 시간 (YYYY-MM-DD HH24:MI:SS)
	private String uPhoto;
	private String uPhotoBg;
	private String umSns;		// 상태(0:일반로그인, 1:sns로그인)
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public Date getuJoinDate() {
		return uJoinDate;
	}
	public void setuJoinDate(Date uJoinDate) {
		this.uJoinDate = uJoinDate;
	}
	public String getuPhoto() {
		return uPhoto;
	}
	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}
	public String getuPhotoBg() {
		return uPhotoBg;
	}
	public void setuPhotoBg(String uPhotoBg) {
		this.uPhotoBg = uPhotoBg;
	}
	public String getUmSns() {
		return umSns;
	}
	public void setUmSns(String umSns) {
		this.umSns = umSns;
	}
	
	
	
	
}
