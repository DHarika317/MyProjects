package org.javahd.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JDBC2 {

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
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the rollno");
			int rollno = s.nextInt();
			System.out.println("Enter the student name");
			s.nextLine();
			String studname = s.nextLine();
			System.out.println("Enter the date of birth (yyyy-MM-dd)");
			String dob1 = s.nextLine(); //input the date as string from the user
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); //Class to parse the text to date in required format 
			java.util.Date d = sd.parse(dob1); //method which parse the string text to date 
			Date dob = new Date(d.getTime()); //convert util date to sql date
			System.out.println("Enter the marks");
			int mrks = s.nextInt();
			//insert into studInfo values(104, 'Haritha', '1994-10-12', 91)
			String sql = "insert into studInfo values("+rollno+", '"+studname+"', '"+dob+"', "+mrks+")";
			System.out.println(sql);
			stmt.execute(sql);
			stmt.close();con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


