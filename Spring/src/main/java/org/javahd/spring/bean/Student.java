package org.javahd.spring.bean;

import java.util.Set;

public class Student {
	private int rollno;
	private String name;
	private String dept;
	private int fee;
	Set<Address> addresses;
	
	//After setting bean properties the below method gets called (After properties got set)
	public void init(){
		System.out.println("Student init method called");
	}
	//Called while spring gets shut down
	public void destroy(){
		System.out.println("Student destroy method called");
	}
	//when you create a bean the constructor method is called first (Before properties got set)
	public Student() {
		super();
		System.out.println("Student object created");
	}
	
	public Student(int rollno, String name, String dept, int fee) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.dept = dept;
		this.fee = fee;
	}

	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		System.out.println("Getter for student name");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Set<Address> getAddress() {
		return addresses;
	}
	public void setAddress(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", dept=" + dept + ", fee=" + fee + ", " + addresses + "]";
	}

}
