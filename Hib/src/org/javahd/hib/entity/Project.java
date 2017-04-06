package org.javahd.hib.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "proj_table")
public class Project {
	@Id
	private String projid;
	private String projname;
	private int duration;
	
	public Project() {
	}
	public Project(String projid, String projname, int duration) {
		super();
		this.projid = projid;
		this.projname = projname;
		this.duration = duration;
	}
	
	public String getProjid() {
		return projid;
	}
	public void setProjid(String projid) {
		this.projid = projid;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
