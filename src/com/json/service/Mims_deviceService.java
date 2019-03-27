package com.json.service;

import com.json.model.Mims_device;
import com.json.model.Mims_user;

public interface Mims_deviceService {
	Mims_device selByUser(Mims_user user);
}
