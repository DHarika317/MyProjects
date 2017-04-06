package org.javahd.hib.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deptinfo_table")
public class DepartmentInfo {
	@Id
	private String did;
	private String dname;
	public DepartmentInfo() {
		super();
	}
	public DepartmentInfo(String did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
}