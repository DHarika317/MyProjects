package org.javahd.service;

import java.util.ArrayList;

import javax.jws.WebService;

import org.javahd.bean.Courses;

@WebService(endpointInterface="org.javahd.service.CoursesIntf")
public class CoursesImpl implements CoursesIntf{

	@Override
	public ArrayList<Courses> showCourses()  {
		return dao.showCourses();
	}

	@Override
	public boolean addCourse(String cname, int cdur, int cfee) {
		dao.addCourse(new Courses(0, cname, cdur, cfee));
		return true;
	}

	@Override
	public boolean deleteCourse(int courseid) {
		dao.deleteCourse(courseid);
		return true;
	}

//	@Override
//	public boolean editCourse(String cname, int cdur, int cfee) {
//		dao.editCourse(course);
//		return true;
//	}

}
