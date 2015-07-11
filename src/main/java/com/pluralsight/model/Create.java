package com.pluralsight.model;

import java.sql.ResultSet;

public class Create {
	
	DbConnect dd = DbConnect.instance();
	
	public String CreateUser(String phoneNum, String pass) {
		String result = "0";
		try {
			ResultSet rs = dd.query("select pass from user_tb  " + "where name='" + phoneNum + "'");
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					result = "1";
				}
			} else {
				boolean flag = dd.insert("insert into user_tb(phone,pass) values("+phoneNum+","+pass+")");
				if(flag ) {
					result = "2";
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
