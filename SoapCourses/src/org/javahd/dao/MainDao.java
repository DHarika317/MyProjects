package org.javahd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class MainDao {
		Connection con;
		
		public Connection getConnection(){
			con = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {e.printStackTrace();}
			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javaapps", "java");
			} catch (SQLException e) {e.printStackTrace();}
			return con;
		}
}
