package com.ems.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	

static Connection connection=null;
	
	public DBConnection() {
		super();
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@//localhost:1521/XE";
		String username="system";
		String password="suraj";
		connection=DriverManager.getConnection(url, username, password);
		
		return connection;
	}
}
