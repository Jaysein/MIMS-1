package com.json.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.AndroidUserDao;
import com.json.model.Mims_user;
import com.json.service.AndroidUserService;

@Service
public class AndroidUserServiceImpl implements AndroidUserService {

	@Resource
	private AndroidUserDao androidUserDao;
	
	@Override
	public Mims_user selByName(String user_name) {
		return androidUserDao.selByName(user_name);
	}

}
