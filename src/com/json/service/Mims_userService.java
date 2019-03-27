package com.json.service;

import java.util.List;

import com.json.model.Mims_user;
import com.json.model.PageInfo;

public interface Mims_userService {	
	PageInfo showPage(String user_name, String pageSizeStr, String pageNumberStr);
}
