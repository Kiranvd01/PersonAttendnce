package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbUtility {
	Connection con = null;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiran", "root", "root");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
