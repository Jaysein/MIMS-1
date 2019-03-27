package com.json.dao;

import com.json.model.Mims_device;
import com.json.model.Mims_user;

public interface Mims_deviceDao {
	
	Mims_device selByUserId(Mims_user user);
	
}
