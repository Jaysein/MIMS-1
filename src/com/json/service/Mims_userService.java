package com.json.service;


import java.util.Map;

import com.json.model.Mims_user;
import com.json.model.PageInfo;

public interface Mims_userService {	
	PageInfo showPage(String user_name, String pageSizeStr, String pageNumberStr);
	
	Mims_user selByName(String user_name);
	
	int insUser(Mims_user user);
	
	int updUserStateByName(Map<String, Object>cancelMap);
	
	int updUserByName(Mims_user user);
	
	int selCountByTotalUser();
	
	int selCountByNormalUser();
	
	int selCountByCancelUser();
}
