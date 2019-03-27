package com.json.dao;

import java.util.Map;
import java.util.List;

import com.json.model.Mims_step_number;
import com.json.model.Mims_user;

public interface Mims_step_numberDao {
	List<Mims_step_number> selByTime(Map<String, Object> timeMap);
	
	List<Mims_step_number> selByName(Mims_user user);
}
