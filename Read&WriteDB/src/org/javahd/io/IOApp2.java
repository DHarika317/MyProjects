package org.javahd.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class IOApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "java");
			Statement stmt = con.createStatement();
			FileReader fr = new FileReader("C:\\Users\\harik\\Downloads\\write.txt");
			BufferedReader br = new BufferedReader(fr);
			String s1 = br.readLine();
			while(s1 != null){
				String[] s2 = s1.split(",");
				String sql = "insert into employee values("+s2[0]+", '"+s2[1]+"', '"+s2[2]+"', "+s2[3]+", '"+s2[4]+"', "+s2[5]+")";
				stmt.execute(sql);
				s1 = br.readLine();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
