package com.json.service;

import java.util.Map;

import com.json.model.Mims_device;
import com.json.model.Mims_user;

public interface AUService {
	public Mims_user selUserByNameAndPwd(String username, String password);
	
	public int insUser(Mims_user user);
	
	public Mims_user selUserByName(String username);
	
	public int updUserByName(Mims_user user);
	
	public Mims_device selDevByName(String username);
	
	public int updDevCodeByName(Map<String, Object> map);
	
	public int insDevCodeByName(Map<String, Object> map);
	
	public int updPwdByName(Map<String, String> map);
}
