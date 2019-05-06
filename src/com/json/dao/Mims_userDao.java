package com.json.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.json.model.Mims_user;
import com.json.model.PageInfo;

public interface Mims_userDao {
	
	List<Mims_user> selByPage(PageInfo pageInfo);
	
	long selCountByPage(PageInfo pageInfo);
	
	Mims_user selByName(@Param("user_name")String user_name);
	
	int insUser(Mims_user user);
	
	int updUserStateByName(Map<String, Object>cancelMap);
	
	int updUserByName(Mims_user user);
	
	int selCountByTotalUser();
	
	int selCountByNormalUser();
	
	int selCountByCancelUser();
}
