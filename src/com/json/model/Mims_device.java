package com.json.model;

public class Mims_device {
	
	private int id;
	private int user_id;
	private Mims_user mims_user;
	
	public Mims_device() {
		
	}
	
	public Mims_device(int id, int user_id, Mims_user mims_user) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.mims_user = mims_user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Mims_device [id=" + id + ", user_id=" + user_id + ", mims_user=" + mims_user + "]";
	}
	
}
