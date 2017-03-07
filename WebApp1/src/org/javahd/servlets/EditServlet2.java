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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	PreparedStatement stmt;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javaapps", "java");
			System.out.println("Connection Established");
			stmt = con.prepareStatement(" update product set prodname=?, unitprice=?, Category=? where prodno = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int prodno = Integer.parseInt(request.getParameter("pno"));
		String prodname = request.getParameter("pname");
		String produnitprice = request.getParameter("punitpr");
		String prodcat = request.getParameter("pcatg");
		try {
			stmt.setInt(4, prodno);
			stmt.setString(1, prodname);
			stmt.setString(2, produnitprice);
			stmt.setString(3, prodcat);
			stmt.execute();
			out.println("Row Edited");
			response.setHeader("Refresh", "2;Servjdbc2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.flush();out.close(); 
	}


}
