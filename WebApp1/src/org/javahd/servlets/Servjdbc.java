package org.javahd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servjdbc
 */
@WebServlet("/Servjdbc")
public class Servjdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	PreparedStatement stmt;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javaapps", "java");
			System.out.println("Connection Established");
			stmt = con.prepareStatement("insert into product values (?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int prodno = Integer.parseInt(request.getParameter("pno"));
		String prodname = request.getParameter("pname");
		String produnitprice = request.getParameter("punitpr");
		String prodcat = request.getParameter("pcatg");
		//out.println(name+ "   "+pwd+"   "+ctry);
		try {
			stmt.setInt(1, prodno);
			stmt.setString(2, prodname);
			stmt.setString(3, produnitprice);
			stmt.setString(4, prodcat);
			stmt.execute();
			out.println("Row Inserted");
			response.setHeader("Refresh", "5;Servjdbc2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.flush();out.close(); 
	}

}
