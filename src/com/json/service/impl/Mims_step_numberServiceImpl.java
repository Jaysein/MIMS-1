package com.json.service.impl;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.Mims_step_numberDao;
import com.json.model.Mims_step_number;
import com.json.model.Mims_user;
import com.json.service.Mims_step_numberService;

@Service
public class Mims_step_numberServiceImpl implements Mims_step_numberService {
	
	@Resource
	private Mims_step_numberDao mims_step_numberDao;

	@Override
	public List<Mims_step_number> selByTime(Map<String, Object> timeMap) {
		return mims_step_numberDao.selByTime(timeMap);
	}

	@Override
	public List<Mims_step_number> selByName(Mims_user user) {
		return mims_step_numberDao.selByName(user);
	}

}
