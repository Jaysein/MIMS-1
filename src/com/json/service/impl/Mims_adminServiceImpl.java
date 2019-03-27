package com.json.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.Mims_adminDao;
import com.json.model.Mims_admin;
import com.json.service.Mims_adminService;

@Service
public class Mims_adminServiceImpl implements Mims_adminService {
	@Resource
	private Mims_adminDao mims_adminDao;

	@Override
	public Mims_admin selByMims_admin(Mims_admin admin) {
		return mims_adminDao.selByMims_admin(admin);
	}
	
}
