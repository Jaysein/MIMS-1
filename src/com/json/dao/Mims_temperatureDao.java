package com.json.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.json.model.Mims_temperature;
import com.json.model.Mims_user;

public interface Mims_temperatureDao {
	List<Mims_temperature> selByTime(Map<String, Object> timeMap);
	
	int insByDeviceCode(Map<String, Object> tempMap);
	
}
