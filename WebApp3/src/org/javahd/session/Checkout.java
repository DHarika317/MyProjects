package org.javahd.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javahd.model.Product;

import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(true);
		

		try{
		String email = session.getAttribute("email").toString();		
		out.println("welcome " +email+ "<br>");
		out.println("<br><a href='Checkout'>Checkout</a><br>");
		out.println("<a href='Logout'>Logout</a><br>");
		ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cart");
		int cost = 0;
		if(cartList.isEmpty()){
			out.println("<h3>Your cart is empty</h3>");
		}
		else{	
			for(Product p: cartList){
				
				 out.println("<form method='post' action = 'delItem'>");
				 out.println("<table>");
				 out.println("<tr><td> "
					+"<input type='hidden' name = 'itemid' value='"+p.getItemId()+"'>"
					+ "<input type='hidden' name = 'itemname' value='"+p.getItemName()+"'>"
					+ "<input type='hidden' name = 'price' value='"+p.getPrice()+"'>"
					+ "<input type='hidden' name = 'qty' value='"+p.getQuantity()+"'>"
				 	+ "Item  id = "+p.getItemId()+"</td>"
			 		+ "</tr>"
			        + "<tr><td>"+p.getItemName()+"</td></tr>"
			 		+ "<tr><td> $ "+p.getPrice()+"</td><td> "+p.getQuantity()+" </td></tr>"
			 		+ "<tr><td><input type = 'submit' value='DELETE ITEM'></td><tr>");
			 out.println("</table></form>");
			 out.println("<hr>");
			 cost += p.getPrice();
			}
			out.println("Total Cost is $ " +cost);
		}
		}catch(NullPointerException e){
			out.println("Not logged in <br>");
			response.setHeader("Refresh", "1;login.html");;
		}
			
	}

}
