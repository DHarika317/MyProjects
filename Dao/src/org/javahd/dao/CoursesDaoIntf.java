package org.javahd.dao;

import java.util.ArrayList;

import org.javahd.bean.Courses;

public interface CoursesDaoIntf {
	public ArrayList<Courses> showCourses();
	public boolean addCourse(Courses course);
	public boolean deleteCourse(int courseid);
	public boolean editCourse(Courses course);
}
