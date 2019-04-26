package com.json.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.json.model.Mims_device;
import com.json.model.Mims_user;

public interface AUDao {
	
	/**
	 * �����û����������ѯ����
	 * @param username �û���
	 * @param password ����
	 * @return ��ѯ���Ķ���
	 */
	public Mims_user selUserByNameAndPwd(@Param("username")String username, @Param("password")String password);
	
	
	/**
	 * ��������
	 * @param user ��Ҫ����Ķ���
	 * @return ��Ӱ�������
	 */
	public int insUser(Mims_user user);
	
	/**
	 * �����û�����ѯ����
	 * @param username �û���
	 * @return ��ѯ���Ķ���
	 */
	public Mims_user selUserByName(@Param("username")String username);
	
	/**
	 * �����û����޸�����
	 * @param user ������û�����
	 * @return ��Ӱ�������
	 */
	public int updUserByName(Mims_user user);
	
	/**
	 * �����û�����ѯ�û����豸
	 * @param username
	 * @return
	 */
	public Mims_device selDevByName(@Param("username")String username);
	
	/**
	 * �����û����޸�ָ���û����豸id
	 * @param username �û���
	 * @param deviceCode �豸id
	 * @return ��Ӱ�������
	 */
	public int updDevCodeByName(Map<String, Object> map);
	
	/**
	 * ��������
	 * @param map ���������map����
	 * @return ��Ӱ�������
	 */
	public int insDevCodeByName(Map<String, Object> map);
	
	/**
	 * �����û����޸�����
	 * @param map ���������map����
	 * @return ��Ӱ��ĺ���
	 */
	public int updPwdByName(Map<String, String> map);
}
