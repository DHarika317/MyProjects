package org.javahd.rest.client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement            
//The class object can be represented as xml/json with the above annotation.
public class Courses {
	private int courseId;
	private String courseName;
	private int duration;
	private int fee;
	
	public Courses() {
		super();
	}
	public Courses(int courseId, String courseName, int duration, int fee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", fee="
				+ fee + "]";
	}

}
