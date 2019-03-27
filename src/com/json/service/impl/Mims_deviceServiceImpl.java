package com.json.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.Mims_deviceDao;
import com.json.model.Mims_device;
import com.json.model.Mims_user;
import com.json.service.Mims_deviceService;

@Service
public class Mims_deviceServiceImpl implements Mims_deviceService {
	@Resource
	private Mims_deviceDao mims_deviceDao;
	
	@Override
	public Mims_device selByUser(Mims_user user) {
		return mims_deviceDao.selByUserId(user);
	}

}
