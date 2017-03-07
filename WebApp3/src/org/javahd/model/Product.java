package org.javahd.model;

public class Product {
	
	private int itemId;
	private String itemName;
	private int price;
	private int quantity;
	
	public Product(int itemId, String itemName, int price, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return quantity*price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object obj) {
		Product other = (Product) obj;
		return (this.itemId==other.itemId && this.itemName.equals(other.itemName) && this.price == other.price
				&& this.quantity == other.quantity);		
	}
}


