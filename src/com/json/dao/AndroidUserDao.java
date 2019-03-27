package com.json.dao;

import org.apache.ibatis.annotations.Param;

import com.json.model.Mims_user;

public interface AndroidUserDao {

	Mims_user selByName(@Param("user_name")String user_name);
}
