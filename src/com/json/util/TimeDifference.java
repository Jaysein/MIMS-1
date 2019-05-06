package com.json.util;

import java.sql.ResultSet;
import java.sql.SQLException;




public class TimeDifference {
	public static void main(String[] args) {
		String sql = "select * from mims_user where user_name=?";
		String[] info = {"уехЩ"};
		
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		try {
			if (rs != null) {
				if (rs.next()) {
					String username = rs.getString("user_name");
					System.out.println(username);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
