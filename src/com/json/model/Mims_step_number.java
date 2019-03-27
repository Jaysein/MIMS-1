package com.json.model;

import java.util.Date;

public class Mims_step_number {
	private int id;
	private int device_id;
	private int value;
	private Date time;
	private Mims_device mims_device;
	
	public Mims_step_number() {
		
	}

	public Mims_step_number(int id, int device_id, int value, Date time, Mims_device mims_device) {
		super();
		this.id = id;
		this.device_id = device_id;
		this.value = value;
		this.time = time;
		this.mims_device = mims_device;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Mims_device getMims_device() {
		return mims_device;
	}

	public void setMims_device(Mims_device mims_device) {
		this.mims_device = mims_device;
	}

	@Override
	public String toString() {
		return "Mims_step_number [id=" + id + ", device_id=" + device_id + ", value=" + value + ", time=" + time
				+ ", mims_device=" + mims_device + "]";
	}
	
	
}
