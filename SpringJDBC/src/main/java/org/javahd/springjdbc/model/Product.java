package org.javahd.springjdbc.model;

public class Product {
	private int prodNo;
	private String prodName;
	private int price;
	private String category;
	public Product() {
		super();
	}
	public Product(int prodNo, String prodName, int price, String category) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.price = price;
		this.category = category;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", price=" + price + ", category=" + category
				+ "]";
	}
	

}
