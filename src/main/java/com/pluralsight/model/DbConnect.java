package com.pluralsight.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	
	private static DbConnect op;
	private Connection conn ;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dai";
	private String username = "root";
	private String pass = "root";
	


	
	
	public DbConnect() throws ClassNotFoundException, SQLException
		
	{
			

			Class.forName(driver);

			conn = DriverManager.getConnection(url,username,pass);

		
	}


	
	//获取数据库连接
	public void getConnection() throws Exception {
		if(conn == null) {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url,username,pass);
		}
	}
	
	//实例化javabean入口
	
	public static DbConnect instance() 
		
	{
		if (op == null) {
			try {
				op = new DbConnect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return op;
	}
	
	//插入记录
	public boolean insert(String sql) throws Exception {
		getConnection();
		Statement stmt = this.conn.createStatement() ;
		if ( stmt.execute(sql)) {
			return false;
		}
		return true;
	}
	
	//查询记录
	public ResultSet query (String sql ) throws Exception {
		getConnection();
		Statement stmt = this.conn.createStatement() ;
		return stmt.executeQuery(sql);
	}
	
	
	//执行删除
	public void delete (String sql) throws Exception {
		getConnection();
		Statement stmt = this.conn.createStatement() ;
		 stmt.executeUpdate(sql);
	}
	
	//执行更新
	public void update(String sql ) throws Exception {
		getConnection();
		Statement stmt = this.conn.createStatement() ;
		stmt.executeUpdate(sql);
	}
	
}
