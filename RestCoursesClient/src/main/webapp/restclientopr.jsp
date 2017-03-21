<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.client.Entity"%>
<%@page import="org.javahd.rest.client.Courses"%>
<%@page import="javax.ws.rs.core.Response"%>
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
	<%!String action;
	String resp = null;
	public static final String REST_ENDPOINT = "http://localhost:8080/RestCoursesService/webapi";
	public static final String URI_INFO_PATH = "/courses";
	String endpoint = REST_ENDPOINT;%>
	<%
		Client client = ClientBuilder.newClient();
	    WebTarget target;
		action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			String cid = request.getParameter("courseid");
			System.out.println(cid);
			//path param
			target = client.target(endpoint + URI_INFO_PATH + "/" + cid);
			//Query Param
			//target = client.target(endpoint + URI_INFO_PATH + "/queryparams").queryParam("cid", cid);
			Response rs = target.request().delete();
			System.out.println(rs);
		}else if(action.equalsIgnoreCase("add")){
			String cname = request.getParameter("cname");
			int cdur = Integer.parseInt(request.getParameter("cdur"));
			int cfee = Integer.parseInt(request.getParameter("cfee"));
			Courses c = new Courses(0,cname,cdur,cfee);
			target = client.target(endpoint + URI_INFO_PATH);
			Response rs = target.request().post(Entity.entity(c, MediaType.APPLICATION_JSON));
			System.out.println(rs);
			
		}else if(action.equalsIgnoreCase("edit")){
			int cid = Integer.parseInt(request.getParameter("cid"));
			String cname = request.getParameter("cname");
			int cdur = Integer.parseInt(request.getParameter("cdur"));
			int cfee = Integer.parseInt(request.getParameter("cfee"));
			Courses c = new Courses(cid,cname,cdur,cfee);
			target = client.target(endpoint + URI_INFO_PATH);
			Response rs = target.request().put(Entity.entity(c, MediaType.APPLICATION_JSON));
			System.out.println(rs);	
		}
		
		response.sendRedirect("restclient.jsp");
		//response.setHeader("Refresh", "1;restclientget.jsp");
	%>
</body>
</html>