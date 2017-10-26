package com.card.entity;

import java.io.Serializable;

public class User implements Serializable{

	private String openId;
	private String phone;
	private String userName;
	private String userSex;
	private String userSchool;
	private String userMajor;
	private String userPhoto;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserSchool() {
		return userSchool;
	}

	public String getUserMajor() {
		return userMajor;
	}

	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "User{" +
				"openId='" + openId + '\'' +
				", phone='" + phone + '\'' +
				", userName='" + userName + '\'' +
				", userSex='" + userSex + '\'' +
				", userSchool='" + userSchool + '\'' +
				", userMajor='" + userMajor + '\'' +
				", userPhoto='" + userPhoto + '\'' +
				'}';
	}
}
