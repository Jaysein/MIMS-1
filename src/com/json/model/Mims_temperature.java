package com.json.model;

import java.util.Date;

public class Mims_temperature {
	private int id;
	private int device_id;
	private double value;
	private Date time;
	private Mims_device mims_device;
	
	public Mims_temperature() {
		
	}

	public Mims_temperature(int id, int device_id, double value, Date time, Mims_device mims_device) {
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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
		return "Mims_temperature [id=" + id + ", device_id=" + device_id + ", value=" + value + ", time=" + time
				+ ", mims_device=" + mims_device + "]";
	}

	
	
}
