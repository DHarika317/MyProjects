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

/**
 * Servlet implementation class CartList
 */
@WebServlet("/CartList")
public class CartList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(true);
		

		try{
		String email = session.getAttribute("email").toString();		
		out.println("welcome " +email+ "<br>");
		
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		String itemname = request.getParameter("itemname");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		
		Product p = new Product(itemid,itemname,price,quantity);
		ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cart");
		cartList.add(p);
		session.setAttribute("cart", cartList);
		response.sendRedirect("Checkout");
		
	}catch(NullPointerException e){
		out.println("Not logged in <br>");
		response.setHeader("Refresh", "1;login.html");;
	}

}
}
