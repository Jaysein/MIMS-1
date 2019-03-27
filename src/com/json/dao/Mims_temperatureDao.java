package com.json.dao;

import java.util.Map;
import java.util.List;

import com.json.model.Mims_temperature;
import com.json.model.Mims_user;

public interface Mims_temperatureDao {
	List<Mims_temperature> selByTime(Map<String, Object> timeMap);
	
	List<Mims_temperature> selByName(Mims_user user);
}
