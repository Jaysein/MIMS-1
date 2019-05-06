package com.json.util;

public class SQLHelp {
	public int insTempData(String deviceCode, double tempData) {
		String sql = "insert into mims_temperature values(default,?,?,default)";
		String[] info = {Integer.parseInt(deviceCode)+"", tempData+""};
		
		int result = JDBCUtil.executeUpdate(sql, info);
		return result;
	}
	
	public int insHeartData(String deviceCode, int heartData) {
		String sql = "insert into mims_heart_rate values(default,?,?,default)";
		String[] info = {Integer.parseInt(deviceCode)+"", heartData+""};
		
		int result = JDBCUtil.executeUpdate(sql, info);
		return result;
	}
}
