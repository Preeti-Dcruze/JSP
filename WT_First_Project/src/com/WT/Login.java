package com.WT;

import java.sql.*;

//import javax.print.attribute.standard.PrinterLocation;

public class Login {

	public static Statement stmt = null;
	public static Connection con = null;

	public static boolean getResultSet(String dburl, String dbuser, String dbpassword, String uname, String psswrd,
			User u) throws ClassNotFoundException {
		try {

			// Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(uname + " " + psswrd);
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
			stmt = con.createStatement();
			String query = "select * from Users where username='" + uname + "' and pssword='" + psswrd + "'";
			// String query = "select * from Users where username='Preeti-Dcruze' and
			// pssword='1234'";
			ResultSet rs = stmt.executeQuery(query);
			if (rs != null) {
				System.out.println("In rs");
				if (rs.next()) {
					u.setFullname(rs.getString("fullname"));
					u.setEmail(rs.getString("emailid"));
//					System.out.println();
//					System.out.println();
					return true;
				} else {
					System.out.println("Fail");
					return false;
				}

			} else {
				System.out.println("Login Failed");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
