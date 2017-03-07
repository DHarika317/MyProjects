package org.javahd.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		int prodno = Integer.parseInt(request.getParameter("pno"));
//		String prodname = request.getParameter("pname");
//		String produnitprice = request.getParameter("punitpr");
//		String prodcat = request.getParameter("pcatg");
		out.println("<form method = 'post' action = 'EditServlet2'>"
				+ "<table width = 60%><tr><td>Product Number</td><td><input type = 'text' name = 'pno' value = '"+request.getParameter("prodno")+"'></td></tr>"
				+ "<tr><td>Product Name</td><td><input type = 'text' name = 'pname' value = '"+request.getParameter("prodname")+"'></td></tr>"
				+ "<tr><td>Unit Price</td><td><input type = 'text' name = 'punitpr' value = '"+request.getParameter("unitprice")+"'></td></tr>"
				+ "<tr><td>Category</td><td><input type = 'text' name = 'pcatg' value = '"+request.getParameter("catagory")+"'></td></tr>"
				+ "<tr><td></td><td><input type = 'submit' value ='SUBMIT'></td></tr></table>"
				+ "</form>");
		
		out.flush(); out.close();
	}

}
