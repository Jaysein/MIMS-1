package com.json.model;

import java.util.Date;

public class Mims_user {
	//用户id
	private Integer id;
	//用户名
	private String user_name;
	//密码
	private String password;
	//电子邮箱
	private String e_mail;
	//联系电话
	private String phone;
	//性别
	private Integer sex;
	//年龄
	private Integer age;
	//身高
	private Double height;
	//体重
	private Double weight;
	//用户状态
	private Integer user_status;
	//创建时间
	private Date create_time;
	//注销时间
	private Date cancel_time;
	
	public Mims_user() {
		
	}

	public Mims_user(Integer id, String user_name, String password, String e_mail, String phone, Integer sex,
			Integer age, Double height, Double weight, Integer user_status, Date create_time, Date cancel_time) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.e_mail = e_mail;
		this.phone = phone;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.user_status = user_status;
		this.create_time = create_time;
		this.cancel_time = cancel_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getUser_status() {
		return user_status;
	}

	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
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
		return "Mims_user [id=" + id + ", user_name=" + user_name + ", password=" + password + ", e_mail=" + e_mail
				+ ", phone=" + phone + ", sex=" + sex + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", user_status=" + user_status + ", create_time=" + create_time + ", cancel_time=" + cancel_time
				+ "]";
	}
	
	
}
