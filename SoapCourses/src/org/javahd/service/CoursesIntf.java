package org.javahd.service;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.javahd.bean.Courses;
import org.javahd.dao.CoursesDao;
import org.javahd.dao.DaoFactory;
//whatever functions you need to deliver as a web service should be defined as interface
//WSDL gets all its definitions from this interface
@WebService
public interface CoursesIntf {
	CoursesDao dao = (CoursesDao)DaoFactory.getdao("CoursesDao");
	@WebMethod
	public ArrayList<Courses> showCourses();
	@WebMethod
	public boolean addCourse(String cname, int cdur, int cfee);
	@WebMethod
	public boolean deleteCourse(int courseid);
//	@WebMethod
//	public boolean editCourse(String cname, int cdur, int cfee);
	
}
