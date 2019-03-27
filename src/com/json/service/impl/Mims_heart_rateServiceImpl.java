package com.json.service.impl;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.Mims_heart_rateDao;
import com.json.model.Mims_heart_rate;
import com.json.model.Mims_user;
import com.json.service.Mims_heart_rateService;

@Service
public class Mims_heart_rateServiceImpl implements Mims_heart_rateService {
	
	@Resource
	private Mims_heart_rateDao mims_heart_rateDao;

	@Override
	public List<Mims_heart_rate> selByTime(Map<String, Object> timeMap) {
		return mims_heart_rateDao.selByTime(timeMap);
	}

	@Override
	public List<Mims_heart_rate> selByName(Mims_user user) {
		return mims_heart_rateDao.selByName(user);
	}

}
