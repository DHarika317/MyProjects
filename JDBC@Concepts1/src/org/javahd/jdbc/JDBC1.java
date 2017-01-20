package org.javahd.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "java");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from studInfo");
			while (rs.next()){
				int rollno = rs.getInt(1);
				String name = rs.getString("studname");
				Date dob = rs.getDate(3);
				int mrks = rs.getInt(4);
				System.out.println(rollno+"  "+name+"  "+dob+"  "+mrks);
			}
			rs.close();stmt.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
