package org.javahd.springjdbc;

import java.util.ArrayList;

import org.javahd.springjdbc.dao.ProductDAO;
import org.javahd.springjdbc.dao.ProductDAOImpl;
import org.javahd.springjdbc.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring.xml");
		ProductDAO prodDAO = (ProductDAO)cxt.getBean("prodDAO");
		ArrayList<Product> list = prodDAO.showProducts();
		for(Product p : list){
			System.out.println(p);
		}

	}

}
