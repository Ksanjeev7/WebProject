<%@page import="com.Sanju.EmployeeDao"%>
<%@page import="com.Sanju.Employeebo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html>
<html>
	   <link rel="Stylesheet" href="NewFile.css">
	<head>
		<style type="text/css">      

		  .Container{
	   margin:auto;
	   padding:50pt;
	   width: 15%;
	   box-sizing: content-box;
	   background-color: burlywood;
	   box-shadow: 1px 1px 0px 2px;      
	    }
		
		input[type = 'number'],
        input[type = 'text'],
         input[type= 'text']
         input[type = 'text']
        {
			width: auto;
			padding:5px;
			margin: 15px 5px 5px 1px;
			display: inline-block;
			border: none;
			background-color: whitesmoke;
			box-sizing: border-box;
		}
             input[type = 'text'],
             input[type= 'number'],
             input[type= 'text']
             input[type= 'text']
              input[type= 'text']
             {
				  background-color: whitesmoke;
				  outline: sandybrown;
			 }
				
		 .submitbtn{
		  background-color: lightblue;
		  color: bisque;
		  padding: 5%;
		  border: none;
		  margin: auto;
		  cursor: pointer;
		  width: 40%;
		  opacity: 2.0;
	 }
     .submitbtn:hover{
		 opacity: 1.0;
	 }
		</style>
	<meta charset="ISO-8859-1">
	<title>EditEmployee</title>
	</head>
	<body>
	                <div class="Container">
	                 <%= "<form action='Edit2.jsp' method='post'>" %>
	                 <%
	                  Employeebo  empbo = new Employeebo();
	                 EmployeeDao  emp = new EmployeeDao();
	                 String  id = request.getParameter("Id");
	                 int Id = Integer.parseInt(id);
	                  EmployeeDao empdao =empbo.getemployee(Id);
	                 %>
	                  <h2 style = 'color : Blue'><%="Update Employee details"%></h2>
	                 <%="<table>"%>
	                 <%="<tr><td></td><td><input type='hidden' name='Id' value="+empdao.getId()+"></td></tr>"%>
	                 <%="<tr><td>Name:</td><td><input type='name' name='Name' value="+empdao.getName()+"></td></tr>"%>
	                  <%="<tr><td>Email:</td><td><input type='name' name='Email' value="+empdao.getEmail()+"></td></tr>"%>
	                  <%="<tr><td>Dept:</td><td><input type='name' name='Department' value="+empdao.getDepartment()+"></td></tr>"%>
	                  <%="<tr><td>Salary:</td><td><input type='text' name='salary' value="+empdao.getsalary()+"></td></tr>"%>
	                  <%="<tr><td></td><td> <button class='submitbtn'  type=' submit' style='color: darkred;'> Edit</button></td></td></tr>"%>
	                  <%="</table>" %> 
	                  </div>
	                  <%="</form>"%>
	                 
	  </body>
	  </html>               
	                 
	                 