package org.javahd.springhib.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "PROJECT")
public class Project {
	@Override
	public String toString() {
		return "Project [projid=" + projid + ", projname=" + projname + ", duration=" + duration + "]";
	}
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
