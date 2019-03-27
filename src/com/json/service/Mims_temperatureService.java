package com.json.service;

import java.util.List;
import java.util.Map;

import com.json.model.Mims_temperature;
import com.json.model.Mims_user;

public interface Mims_temperatureService {
	List<Mims_temperature> selByTime(Map<String, Object>timeMap);
	
	List<Mims_temperature> selByName(Mims_user user);
}
