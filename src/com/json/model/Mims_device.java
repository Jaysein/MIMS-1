package com.json.model;

import java.util.Date;

public class Mims_device {
	
	private int id;
	private String deviceCode;
	private Date create_time;
	private int user_id;
	private Mims_user mims_user;
	
	public Mims_device() {
		super();
	}

	public Mims_device(int id, String deviceCode, Date create_time, int user_id, Mims_user mims_user) {
		super();
		this.id = id;
		this.deviceCode = deviceCode;
		this.create_time = create_time;
		this.user_id = user_id;
		this.mims_user = mims_user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Mims_user getMims_user() {
		return mims_user;
	}

	public void setMims_user(Mims_user mims_user) {
		this.mims_user = mims_user;
	}

	@Override
	public String toString() {
		return "Mims_device [id=" + id + ", deviceCode=" + deviceCode + ", create_time=" + create_time + ", user_id="
				+ user_id + ", mims_user=" + mims_user + "]";
	}
	
}
