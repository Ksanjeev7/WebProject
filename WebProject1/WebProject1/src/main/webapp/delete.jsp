<%@page import="com.Sanju.EmployeeDao"%>
<%@page import="com.Sanju.Employeebo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>DeleteServlet</title>
	</head>
	<body>
	         <%
             Employeebo  empbo = new Employeebo();
	         int id= Integer.parseInt(request.getParameter("Id"));
             int deletedemp =  empbo.Delete(id);
                          if(deletedemp >0){
                        	 out.print("<h2>Deleted Successfully</h2>");
                        	 response.sendRedirect("ViewAll.jsp");       
                          }else{
                          	out.println("<h2> Not Deleted...<?h2>");
                          }
             
	         %>
	</body>
</html>