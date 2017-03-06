package org.javahd.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

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
			System.out.println("Please select an option from the below \n 1. Add a new employee \n "
					+ "2. Show all employees \n 3. Delete an employee by employee number \n "
					+ "4. Search an employee by job \n 5. Exit");
			
			Scanner s = new Scanner(System.in);
			Statement stmt = con.createStatement();
			int choice;
			do{
			System.out.println("Enter the choice");
			choice = s.nextInt();
			
			int empno; String empname; String empjob;
			switch(choice){
			case 1:
				PreparedStatement stmt1 = con.prepareStatement("insert into employee values(?,?,?)");
				System.out.println("Enter the Employee no");
				empno = s.nextInt();
				System.out.println("Enter the Employee name");
				s.nextLine();
				empname = s.nextLine();
				System.out.println("Enter the Employee job");
				empjob = s.nextLine();
				stmt1.setInt(1, empno);
				stmt1.setString(2, empname);
				stmt1.setString(3, empjob);
				stmt1.execute();
				System.out.println(empno+"   "+empname+"   "+empjob);
				stmt1.close();
				break;
			case 2: 		
				ResultSet rs = stmt.executeQuery("Select * from employee");
				while(rs.next()){
					empno = rs.getInt(1);
					empname = rs.getString(2);
					empjob = rs.getString(3);
					System.out.println(empno+"   "+empname+"   "+empjob);
				}
				rs.close();
				break;
			case 3:
				System.out.println("Enter the employee number");
				int empnumb = s.nextInt();
				ResultSet rs1 = stmt.executeQuery("Select * from employee where empno=" +empnumb); 
				while(rs1.next()){
					empno = rs1.getInt(1);
					empname = rs1.getString(2);
					empjob = rs1.getString(3);
					System.out.println(empno+"   "+empname+"   "+empjob);	
			   }
				stmt.executeUpdate("delete from employee where empno="+empnumb);
				System.out.print("record is deleted");
				System.out.println();
				rs1.close();
				break;
			
			case 4:
				System.out.println("Enter the job of employee");
				s.nextLine();
				String job = s.nextLine();
				System.out.println(job);
				ResultSet rs2 = stmt.executeQuery("Select * from employee where empjob ='"+job+"'");
				while(rs2.next()){
					empno = rs2.getInt(1);
					empname = rs2.getString(2);
					empjob = rs2.getString(3);
					System.out.println(empno+"   "+empname+"   "+empjob);
				}
				rs2.close();
				break;
			
			case 5:
				System.out.println("Exited from application");
				//System.exit(0);
				break;
				
			default:
				System.out.println("Choice must be a value between 1 to 5");
				break;
			}
			stmt.close();
			}while(choice != 5);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}


