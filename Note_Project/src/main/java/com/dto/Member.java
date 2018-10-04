package com.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 	UM_ID	NUMBER(5)	유저ID(seq)						uuid
	UM_LOGINID	VARCHAR2(15)	유저 로그인 id				userid
	UM_PASSWD	VARCHAR2(16)	유저 로그인 패스워드			passwd
	UM_NAME	VARCHAR2(10)	유저 이름						name
	UM_EMAIL	VARCHAR2(100)	유저 email				email
	UM_TEL	VARCHAR2(20)	유저 핸드폰번호					tel
	UM_DATE	DATE	회원가입 시간 (YYYY-MM-DD HH24:MI:SS)		joinDate
	UM_PHOTO	VARCHAR2(100)	유저 사진					photo
	UM_PHOTO_BG	VARCHAR2(100)	배경사진					photoBg
	UM_SNS	CHAR(1)	상태(0:일반로그인, 1:sns로그인)			joinState
 */
@Alias("Member")
public class Member {
	private int uuid;
	private String userid;
	private String passwd;
	private String name;
	private String email;
	private String tel;
	private Date joinDate;
	private String photo;
	private String photoBg;
	private String joinState;
	
	public Member() { }
	public Member(int uuid, String userid, String passwd, String name, String email, String tel, Date joinDate,
			String photo, String photoBg, String joinState) {
		super();
		this.uuid = uuid;
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.joinDate = joinDate;
		this.photo = photo;
		this.photoBg = photoBg;
		this.joinState = joinState;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhotoBg() {
		return photoBg;
	}

	public void setPhotoBg(String photoBg) {
		this.photoBg = photoBg;
	}

	public String getJoinState() {
		return joinState;
	}

	public void setJoinState(String joinState) {
		this.joinState = joinState;
	}
	
	
	
}
