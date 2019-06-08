package com.linzhehang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql:///pagecurd";
	private static String user = "root";
	private static String password = "linzhehang";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getCon() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void free(Connection con, Statement sta, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (sta != null)
					sta.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}

}
