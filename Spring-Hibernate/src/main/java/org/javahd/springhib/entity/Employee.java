package org.javahd.springhib.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	private String empno;
	private String empName;
	private String job;
	@Column(name="salary")
	private int sal;
	@Temporal(TemporalType.DATE)
	private Date doj;

	@ManyToOne
	Project project;
	
	public Employee(String empno, String empName, String job, int sal, Date doj) {
		super();
		this.empno = empno;
		this.empName = empName;
		this.job = job;
		this.sal = sal;
		this.doj = doj;
	}
	
	public Employee() {
		
	}

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empName=" + empName + ", job=" + job + ", sal=" + sal + ", doj=" + doj
				+ ", proj=" +project+  "]";
	}
	
}
