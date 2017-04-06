package org.javahd.hib.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String aptNo;
	private String city;
	private String state;
	private String zip;
	public Address() {
		super();
	}
	public Address(String street, String aptNo, String city, String state, String zip) {
		super();
		this.street = street;
		this.aptNo = aptNo;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAptNo() {
		return aptNo;
	}
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", AptNo=" + aptNo + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}
	

}
