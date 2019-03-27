package com.json.model;

import java.sql.Date;

public class Mims_admin {
	//管理员id
	private int id;
	//用户名
	private String admin_name;
	//密码
	private String password;
	//真实姓名
	private String real_name;
	//管理员类型
	private int admin_type;
	//管理员状态
	private int admin_status;
	//创建时间
	private Date create_time;
	//注销时间
	private Date cancel_time;
	
	public Mims_admin() {
		
	}

	public Mims_admin(int id, String admin_name, String password, String real_name, int admin_type, int admin_status,
			Date create_time, Date cancel_time) {
		super();
		this.id = id;
		this.admin_name = admin_name;
		this.password = password;
		this.real_name = real_name;
		this.admin_type = admin_type;
		this.admin_status = admin_status;
		this.create_time = create_time;
		this.cancel_time = cancel_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public int getAdmin_type() {
		return admin_type;
	}

	public void setAdmin_type(int admin_type) {
		this.admin_type = admin_type;
	}

	public int getAdmin_status() {
		return admin_status;
	}

	public void setAdmin_status(int admin_status) {
		this.admin_status = admin_status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getCancel_time() {
		return cancel_time;
	}

	public void setCancel_time(Date cancel_time) {
		this.cancel_time = cancel_time;
	}

	@Override
	public String toString() {
		return "Mims_admin [id=" + id + ", admin_name=" + admin_name + ", password=" + password + ", real_name="
				+ real_name + ", admin_type=" + admin_type + ", admin_status=" + admin_status + ", create_time="
				+ create_time + ", cancel_time=" + cancel_time + "]";
	}
	
}
