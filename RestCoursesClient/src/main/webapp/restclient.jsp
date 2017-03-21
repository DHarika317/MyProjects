<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.client.ClientBuilder"%>
<%@page import="javax.ws.rs.client.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String resp = null; %>
<% Client client = ClientBuilder.newClient();
//WebTarget target = client.target("http://localhost:8080/RestCourses/webapi/courses");
WebTarget target = client.target("http://localhost:8080/RestCoursesService/webapi").path("courses");
resp = target.request().get(String.class);
//System.out.println(resp);

JSONArray jsonArr = new JSONArray(resp);
%>
<h3>Course Details</h3>
<table border=1><tr><th>Course ID</th><th>Course Name</th><th>Duration(in days)</th><th>Fee(in $)</th><th>Delete</th><th>Edit</th></tr>
<% 
for (int i = 0; i < jsonArr.length(); i++)
{
    JSONObject jsonObj = jsonArr.getJSONObject(i);
    int cid = Integer.parseInt(jsonObj.get("courseId").toString());
    String cname = jsonObj.get("courseName").toString();
    int fee = Integer.parseInt(jsonObj.get("fee").toString());
    int duration = Integer.parseInt(jsonObj.get("duration").toString());
    //System.out.println(jsonObj);   
%>
<tr><td><%= cid %></td><td><%= cname %></td><td><%= duration %></td><td><%= fee %></td>
<td><a href = 'restclientopr.jsp?action=delete&courseid=<%= cid %>' onclick='return confirm("Do You want to delete this course?")'> Delete Course</a></td>
<td><a href = 'add&editform.jsp?action=edit&courseid=<%= cid %>&coursename=<%=cname.replace("+", "%2B")%>&coursedur=<%=duration%>&coursefee=<%=fee%>' onclick='return confirm("Do You want to edit this course?")'> Edit Course</a></td>
<tr>
<% } %>
</table>
<a href = 'add&editform.jsp?action=add' onclick='return confirm("You want to add a course?")'>Add Course</a> 
</body>
</html>