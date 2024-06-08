package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutils {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/election" ; 
	public static final String DB_USER = "root";
	public static final String DB_PWD = "Fifa";
	


static {
	try {
		
		Class.forName(DB_DRIVER);
		
	}
	catch (ClassNotFoundException e)
	{e.printStackTrace();
	System.exit(1);
	}
	
}
public static Connection getConnection() throws 
SQLException {
	Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
	return con;
}
}
