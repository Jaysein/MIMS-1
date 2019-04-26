package com.json.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.json.model.Mims_device;
import com.json.model.Mims_user;

public interface AUDao {
	
	/**
	 * 根据用户名和密码查询数据
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询到的对象
	 */
	public Mims_user selUserByNameAndPwd(@Param("username")String username, @Param("password")String password);
	
	
	/**
	 * 插入数据
	 * @param user 需要插入的对象
	 * @return 受影响的行数
	 */
	public int insUser(Mims_user user);
	
	/**
	 * 根据用户名查询数据
	 * @param username 用户名
	 * @return 查询到的对象
	 */
	public Mims_user selUserByName(@Param("username")String username);
	
	/**
	 * 根据用户名修改数据
	 * @param user 传入的用户对象
	 * @return 受影响的行数
	 */
	public int updUserByName(Mims_user user);
	
	/**
	 * 根据用户名查询用户的设备
	 * @param username
	 * @return
	 */
	public Mims_device selDevByName(@Param("username")String username);
	
	/**
	 * 根据用户名修改指定用户的设备id
	 * @param username 用户名
	 * @param deviceCode 设备id
	 * @return 受影响的行数
	 */
	public int updDevCodeByName(Map<String, Object> map);
	
	/**
	 * 插入数据
	 * @param map 传入参数的map集合
	 * @return 受影响的行数
	 */
	public int insDevCodeByName(Map<String, Object> map);
	
	/**
	 * 根据用户名修改密码
	 * @param map 传入参数的map集合
	 * @return 受影响的函数
	 */
	public int updPwdByName(Map<String, String> map);
}
