package org.javahd.springjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.javahd.springjdbc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("prodDAO")  // A bean for this class is automatically created in bean container with id prodDAO
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired  //The bean for the connection object we created in container is injected using autowired
	DataSource dataSource;
	/** Autowiring happens by placing an instance of one bean into the desired field in an instance of another bean. Both classes should be beans,
	i.e. they should be defined to live in the application context. **/
	
	PreparedStatement ps1;
	public ArrayList<Product> showProducts(){ 
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			Connection con = dataSource.getConnection();  // get the connection from the connection object
			ps1 = con.prepareStatement("select * from product");
			ResultSet rs = ps1.executeQuery();
			while(rs.next()){
				int pno = rs.getInt(1);
				String pname = rs.getString(2);
				int price = rs.getInt(3);
				String catg = rs.getString(4);
				Product p = new Product(pno, pname, price, catg);
				list.add(p);	
			}	
		} catch (SQLException e) {e.printStackTrace();} 
		return list;
		
	}

}
