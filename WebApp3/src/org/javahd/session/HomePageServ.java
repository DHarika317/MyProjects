package org.javahd.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javahd.model.Product;

/**
 * Servlet implementation class HomePageServ
 */
@WebServlet("/HomePageServ")
public class HomePageServ extends HttpServlet {
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
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "webapp", "java");
			System.out.println("Connection Established");
			stmt = con.prepareStatement("select * from items");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(true);
		
		try{
		String email = session.getAttribute("email").toString();
		out.println("welcome " +email+ "<br>");
		ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cart");
		}catch(NullPointerException e){
			out.println("Not logged in <br>");
			response.setHeader("Refresh", "1;login.html");;
		}
		out.println("<a href='Checkout'>Checkout</a><br>");
		out.println("<a href='Logout'>Logout</a><br>");
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
			int itemid = rs.getInt(1);
			String itemname = rs.getString(2);
			String itemdesc =  rs.getString(3);
			int price = rs.getInt(4);
			String imagename = rs.getString(5);
			 out.println("<form method='post' action='CartList'>");
			 out.println("<table>");
			 
			 out.println("<tr><td rowspan = 4> "
			 		+ "<input type='hidden' name = 'itemid' value='"+itemid+"'>"
			 		+ "<input type='hidden' name = 'itemname' value='"+itemname+"'>"
			 		+ "<input type='hidden' name = 'price' value='"+price+"'>"
			 		+ "<img src='flowers/"+imagename+"' alt = '"+imagename+"' width= 200 height= 200 /></td>"
			 		+ "<td> Item  id = "+itemid+"</td>"
			 		+ "</tr>"
			        + "<tr><td>"+itemname+"</td></tr>"
			 		+ "<tr><td>"+itemdesc+"</td></tr>"
			 		+ "<tr><td> $ "+price+"</td><td> Quantity <select name ='qty'> <option>1 <option>2 <option>3 <option>4 <option<5 </option> </select></td></tr>"
			 				+ "<tr><td></td><td><input type = 'submit' value = 'Add to Cart'</td></tr>");
			 out.println("</table></form>");
			 out.println("<hr>");
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
