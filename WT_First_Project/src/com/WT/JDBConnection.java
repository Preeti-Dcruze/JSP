package com.WT;

import java.sql.*;

class JDBConnection{
	
	public static final String url = "jdbc:mysql://localhost:3306/";
	public static final String user = "root";
	public static final String password = "";
	
	public static boolean myConnection(String dbdriver,String dburl,String dbuser,String dbpassword) throws SQLException {
		Connection con = null;
	try {
		Class.forName(dbdriver);
		
		con=DriverManager.getConnection(dburl,dbuser,dbpassword);
		return true;
	}
	catch(Exception e)
	{
		return false;
		//e.printStackTrace();
	}
	finally {
		con.close();
	}
	}
	
//	public static void main(String[] args) {
//		myConnection();
//	}
}
