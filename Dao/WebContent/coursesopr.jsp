<%@page import="org.javahd.bean.Courses"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.javahd.dao.DaoFactory"%>
<%@page import="org.javahd.dao.CoursesDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!CoursesDao dao;
	String action;
	public void jspInit() {
		dao = (CoursesDao) DaoFactory.getdao("CoursesDao");
	}%>
	<%
		action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			dao.addCourse(
					new Courses(0, request.getParameter("cname"), Integer.parseInt(request.getParameter("cdur")),
							Integer.parseInt(request.getParameter("cfee"))));
		} else if (action.equalsIgnoreCase("delete")) {
			dao.deleteCourse(Integer.parseInt(request.getParameter("courseid")));
		}
		else if (action.equalsIgnoreCase("edit")){
			dao.editCourse(new Courses(Integer.parseInt(request.getParameter("cid")), request.getParameter("cname"), 
					Integer.parseInt(request.getParameter("cdur")),
					Integer.parseInt(request.getParameter("cfee"))));
		}
		response.setHeader("Refresh", "1;coursesinfo.jsp");
		%>
	
</body>
</html>