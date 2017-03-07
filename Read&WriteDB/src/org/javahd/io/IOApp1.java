package org.javahd.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IOApp1 {

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
			FileWriter fw = new FileWriter("C:\\Users\\harik\\Downloads\\write.txt");
			//BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(fw);
			ResultSet rs = stmt.executeQuery("Select * from employee");
			while (rs.next()){
				int empno = rs.getInt(1);
				String empname = rs.getString(2);
				String empjob = rs.getString(3);
				int empsal = rs.getInt(4);
				Date empdoj = rs.getDate(5);
				int deptNumb = rs.getInt(6);
				pw.println(empno+",   "+empname+",   "+empjob+",   "+empsal+",   "+empdoj+",   "+deptNumb);
//				String out = empno+",   "+empname+",   "+empjob+",   "+empsal+",   "+empdoj+",   "+deptNumb ; 
//				System.out.println(out);
//				bw.write(out);
//				bw.newLine();				
			}
			System.out.println("the output is written into write.txt file");
			rs.close();stmt.close();con.close();pw.close(); //bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
//drop table employee;
//create table employee(empno int(3) primary key,
//ename varchar(30),
//job varchar(30),
//sal int(9),
//doj date,
//deptno int(2));
//insert into employee values(1, 'Harika', 'Clerk', 5000,'2014-02-13',10 );
//insert into employee values(2, 'Haritha', 'Manager', 7000,'2010-03-12',20 );
//insert into employee values(3, 'Monica', 'Clerk', 5300,'2013-01-04',10 );
//insert into employee values(4, 'Vinaya', 'Analyst', 4500,'2014-12-06',30 );
//insert into employee values(5, 'Aara', 'Accountant', 5500,'2012-09-15',40 );
//insert into employee values(6, 'Sreelatha', 'Accountant', 4500,'2015-04-11',40 );
//insert into employee values(6, 'Sreelatha', 'Accountant', 4500,'2015-04-11',40 );
//insert into employee values(7, 'Ross', 'Clerk', 4900,'2012-11-19',10 );
//insert into employee values(8, 'Joey', 'Analyst', 4600,'2012-01-14',30 );
//delete from employee; --> deletes all rows in a table