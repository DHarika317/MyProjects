package org.javahd.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JDBC3 {

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
			PreparedStatement stmt = con.prepareStatement("insert into studInfo values(?,?,?,?)");
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
			stmt.setInt(1, rollno);
			stmt.setString(2, studname);
			stmt.setDate(3, dob);
			stmt.setInt(4, mrks);			
			System.out.println(rollno+"   "+studname+"   "+dob+"   "+mrks);
			stmt.execute();
			stmt.close();con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


