package com.reborn.web.entity.member;

import java.util.Date;


public class Member {
	   private int id;
	   private String loginId;
	   private String name;
	   private String gender;
	   private String pw;
	   private Date regDate;    
	   private String nickname;
	   private Date birthDay;
	   private String phone;
	   private String email;
	   private Date outDate;
	   private int authorityId;

	   public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String loginId, String name, String gender, String pw, Date regDate, String nickname,
			Date birthDay, String phone, String email, Date outDate, int authorityId) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.gender = gender;
		this.pw = pw;
		this.regDate = regDate;
		this.nickname = nickname;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.outDate = outDate;
		this.authorityId = authorityId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", loginId=" + loginId + ", name=" + name + ", gender=" + gender + ", pw=" + pw
				+ ", regDate=" + regDate + ", nickname=" + nickname + ", birthDay=" + birthDay + ", phone=" + phone
				+ ", email=" + email + ", outDate=" + outDate + ", authorityId=" + authorityId + "]";
	}



	   
}
