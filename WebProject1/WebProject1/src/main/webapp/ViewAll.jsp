<%@page import="com.Sanju.EmployeeDao"%>
<%@page import="java.util.List"%>
<%@page import="com.Sanju.Employeebo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	 <style>
        .Container {
            display: compact;
            flex-wrap:initial;
            background-color : gray;
            justify-content:flex-end;
            width : 100%;
            margin:1pt;
        }

        .employee-card {
         display : inline-block;
         background-color : aqua;
          border: 1pt  solid #ddb;
          width: 150pt;
          padding: 45pt;
          margin: 10pt;
        }
    </style>
		<meta charset="ISO-8859-1">
		<title >Employee Details</title>
	</head>
	<body>
	       <%= "<h4><a href = Form.html  style='color:Red;'>Add New Employee</a></h4>" %>
	       <div class="Container">
	      <%= "<h1 style = 'color:blue;'>Employees List</h1>" %>
	       <% 
	              Employeebo  empbo =  new Employeebo();   
	              List <EmployeeDao> list  =empbo.getAll(); 
	              for(EmployeeDao emp : list){ 
	         %>
	         <div class="employee-card">
            <p><b style="color: blue;">Id:</b> <%= emp.getId() %></p>
            <p><b style="color: blue;">Name:</b> <%= emp.getName() %></p>
            <p><b style="color: blue;">Email:</b> <%= emp.getEmail() %></p>
            <p><b style="color: blue;">Dept:</b> <%= emp.getDepartment() %></p>
            <p><b style="color: blue;">Salary:</b> <%= emp.getsalary() %></p>
            <a href="Editservlet.jsp?Id=<%= emp.getId() %>" style="color: black;">Edit</a>
            <a href="delete.jsp?Id=<%= emp.getId() %>" style="color: black;">Delete</a>
        </div>
        <%
	           }
	     %>
	   </div>
	</body>
</html>