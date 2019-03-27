package com.json.service;

import java.util.List;
import java.util.Map;

import com.json.model.Mims_heart_rate;
import com.json.model.Mims_user;

public interface Mims_heart_rateService {
	List<Mims_heart_rate> selByTime(Map<String, Object>timeMap);
	
	List<Mims_heart_rate> selByName(Mims_user user);
}
