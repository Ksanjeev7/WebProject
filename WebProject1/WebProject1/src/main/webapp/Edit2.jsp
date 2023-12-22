	<%@page import="com.Sanju.EmployeeDao"%>
<%@page import="com.Sanju.Employeebo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Employee details</title>
</head>
<body>
              <%
               Employeebo  empbo = new Employeebo();
              int Id = Integer.parseInt(request.getParameter("Id"));
              String name = request.getParameter("Name");
              String email = request.getParameter("Email");
              String dept = request.getParameter("Department");
              int sal =  Integer.parseInt(request.getParameter("salary"));  
              EmployeeDao  emp = new EmployeeDao(Id,name,email,dept, sal);
               int  res = empbo.UpdateEmp(emp);
               %>
                  <% 
                     if (res >0 ){
                RequestDispatcher dispacher = request.getRequestDispatcher("ViewAll.jsp");
                          dispacher.include(request, response);
                     }
                   else{
                          out.println( "<h2>Sorry! Unable to Update data..</h2>");
                     }
                 %>
</body>
</html>








