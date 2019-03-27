package com.json.service;

import java.util.List;
import java.util.Map;

import com.json.model.Mims_step_number;
import com.json.model.Mims_user;

public interface Mims_step_numberService {
	List<Mims_step_number> selByTime(Map<String, Object>timeMap);
	
	List<Mims_step_number> selByName(Mims_user user);
}
