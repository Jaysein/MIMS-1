package com.json.service.impl;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.Mims_temperatureDao;
import com.json.model.Mims_temperature;
import com.json.model.Mims_user;
import com.json.service.Mims_temperatureService;

@Service
public class Mims_temperatureServiceImpl implements Mims_temperatureService {
	
	@Resource
	private Mims_temperatureDao mims_temperatureDao;

	@Override
	public List<Mims_temperature> selByTime(Map<String, Object> timeMap) {
		return mims_temperatureDao.selByTime(timeMap);
	}

	@Override
	public List<Mims_temperature> selByName(Mims_user user) {
		return mims_temperatureDao.selByName(user);
	}

}
