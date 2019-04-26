package com.json.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.AUDao;
import com.json.model.Mims_device;
import com.json.model.Mims_user;
import com.json.service.AUService;

@Service
public class AUServiceImpl implements AUService {
	
	@Resource
	private AUDao auDao;

	@Override
	public Mims_user selUserByNameAndPwd(String username, String password) {
		
		Mims_user user = auDao.selUserByNameAndPwd(username, password);	
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public int insUser(Mims_user user) {
		int result = auDao.insUser(user);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Mims_user selUserByName(String username) {
		
		Mims_user user = auDao.selUserByName(username);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public int updUserByName(Mims_user user) {
		int result = auDao.updUserByName(user);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updDevCodeByName(Map<String, Object> map) {
		int result = auDao.updDevCodeByName(map);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int insDevCodeByName(Map<String, Object> map) {
		int result = auDao.insDevCodeByName(map);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updPwdByName(Map<String, String> map) {
		int result = auDao.updPwdByName(map);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Mims_device selDevByName(String username) {
		Mims_device device = auDao.selDevByName(username);
		if (device != null) {
			return device;
		}
		return null;
	}

}
