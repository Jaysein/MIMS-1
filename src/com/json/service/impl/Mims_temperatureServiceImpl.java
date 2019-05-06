package com.json.service.impl;

import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.Mims_temperatureDao;
import com.json.model.Mims_temperature;
import com.json.model.Mims_user;
import com.json.service.Mims_temperatureService;

@Service("temps")
public class Mims_temperatureServiceImpl implements Mims_temperatureService {
	
	@Resource
	private Mims_temperatureDao mims_temperatureDao;

	@Override
	public List<Mims_temperature> selByTime(Map<String, Object> timeMap) {
		return mims_temperatureDao.selByTime(timeMap);
	}

	@Override
	public int insByDeviceCode(Map<String, Object> tempMap) {
		System.out.println("+++"+tempMap);
		int result = mims_temperatureDao.insByDeviceCode(tempMap);
		if (result > 0) {
			return result;
		}
		return 0;
	}

}
