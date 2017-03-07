package org.javahd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servjdbc2
 */
@WebServlet("/Servjdbc2")
public class Servjdbc2 extends HttpServlet {
	
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
			stmt = con.prepareStatement("select * from product");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("form2.html");
			rd.include(request, response);
			ResultSet rs = stmt.executeQuery();
			out.println("<table width = 100% border = 1 ><tr><th>Product Number</th><th>Product Name</th><th>Unit Price</th><th>Category</th><th></th><th></th></tr>");
			while(rs.next()){
			int prodno = rs.getInt(1);
			String prodname = rs.getString(2);
			String produnitprice = rs.getString(3);
			String prodcat = rs.getString(4);
			String del = "<a href = 'DelServlet?prodno=" +prodno+ "'>Delete Row</a>";
			String edit = "<a href = 'EditServlet?prodno=" +prodno+ "&prodname=" +prodname+ "&unitprice=" +produnitprice+ "&catagory=" +prodcat+ "'>Edit Row</a>";
			out.println("<tr>"
					+ "<td>"+prodno+"</td>"
					+ "<td>"+prodname+"</td>"
					+ "<td>"+produnitprice+"</td>"
					+ "<td>"+prodcat+"</td>"
					+"<td>"+del+"</td>"
					+"<td>"+edit+"</td>"
					+ "</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
