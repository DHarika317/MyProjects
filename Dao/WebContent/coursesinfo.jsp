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
<%! 
CoursesDao dao;
public void jspInit(){
	dao = (CoursesDao)DaoFactory.getdao("CoursesDao");
}
%>

<h3>Course Details</h3>
<table border=1><tr><th>Course ID</th><th>Course Name</th><th>Duration</th><th>Fee</th><th></th></tr>
<%
///dao.addCourse(new Courses(0,request.getParameter("cname"),Integer.parseInt(request.getParameter("cdur")),Integer.parseInt(request.getParameter("cfee"))));
///dao.deleteCourse(Integer.parseInt(request.getParameter("courseid")));
ArrayList<Courses> list = dao.showCourses();
for(Courses c1:list){
%>
<tr><td><%= c1.getCourseId() %></td><td><%= c1.getCourseName() %></td><td><%= c1.getDuration() %></td><td><%= c1.getFee() %></td>
<td><a href = 'coursesopr.jsp?action=delete&courseid=<%=c1.getCourseId()%>' onclick='return confirm("You want to delete a course?")'>Delete Course</a></td>
<td><a href = 'add&editform.jsp?action=edit&courseid=<%=c1.getCourseId()%>&coursename=<%=c1.getCourseName()%>&coursedur=<%=c1.getDuration()%>&coursefee=<%=c1.getFee()%>' onclick='return confirm("You want to edit this course?")'>Edit Course</a></td>
</tr>
<%
}
%>
</table>
<a href = 'add&editform.jsp?action=add' onclick='return confirm("You want to add a course?")'>Add Course</a> 
</body>
</html>