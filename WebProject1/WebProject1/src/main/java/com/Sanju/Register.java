package com.Sanju;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8057940104278522421L;
	private  static  Connection connection;
	 private static PreparedStatement prStatement;
     private static ResultSet res;
      private static  int count = 2;
	  private  static String S1 = "insert into `customers`(C_Id, C_Name,C_email, C_Address, C_city)values( ?, ?, ?, ? ,?)";
	  private static String S2 = "select * from customers";
	@Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw = response.getWriter();
         response.setContentType("text/html");
          int C_Id=  Integer.parseInt(request.getParameter("Id"));
         String C_Name = request.getParameter("Name");
         String  C_Address = request.getParameter("Address");
         String  password  = request.getParameter("Enter Password");
         String  Confirmpass =request.getParameter("Enter Confirm Password");
         String C_city = request.getParameter("city");
         String C_email = request.getParameter("email");
         if (password .equals(Confirmpass) ) {
		 try {
		       	Class.forName("com.mysql.cj.jdbc.Driver");
				 connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Sanju@71");
				  prStatement = connection.prepareStatement(S1);
				  prStatement.setInt(1, C_Id);
				  prStatement.setString(2, C_Name);
				  prStatement.setString(3, C_email);
				  prStatement.setString(4, C_Address);
				  prStatement.setString(5, C_city);
		 	      int Res= prStatement.executeUpdate();
		 	      System.out.println(Res);
		           prStatement = connection.prepareStatement(S2);
		 	       res = prStatement.executeQuery();
		 	       pw.println("<h2 style ='color:Black'>Register Successfully</h2>");
		 	       pw.println("<html> <head>");
		 	       pw.println("<title>customer Details</title>");
		 	       pw.println(" <style>");
		 	       pw.println("body {font-family :'Airal',sans-serif; background-color:Blue; margin:0; padding:10px;}");
                   pw.println("div.customer-container {display: inline-block; width:100px; margin:40px; padding: 50px; border:100px; background-color :#9BB8CD; } ");
                   pw.println("p{margin :0;}");
                   pw.println("</style>");
                   pw.println( "</head> <body>");
                   pw.println( "<h2 style='text-align : center; '>Customer Details</h2>"); 
				   while (res.next()) {
					pw.println("<div class = 'customer-container'>");
					pw.println(" <p ><b style = 'color :Blue'>C_Id:</b>"+res.getInt(1)+"</p>");
					pw.println("<p> <b style = 'color :Blue'>C_Name:</b>"+res.getString(2)+"</p>"); 
					pw.println("<p> <b style = 'color :Blue'>C_Email:</b> "+res.getString(3)+"</p>");    
					pw.println("<p> <b style = 'color :Blue'>C_Address:</b>"+res.getString(4)+"</p>");  
					pw.println("<p> <b  style = 'color :Blue'>C_city:</b>"+res.getString(5)+ "</p>"); 
					pw.println();
					pw.println(" <a href = 'Employe_edit' style='color:Red' >Edit</a>");
					pw.println();
					pw.println(" <a href = 'DisplayEmploy'   style='color:Red'>Delete</a>"); 
					pw.println("</div>");
				 	 }
				 	 pw.println("</body></html>");
		             }
		            catch (SQLException | ClassNotFoundException e) {
					 e.printStackTrace();
				   }
              }
                else if( count > 0 ) {
 	    	    pw.println("<h2 style='color:red'>Invalid Password....Try Again"  + count +  "Attempts left </h2>");
 	    	      count--;
 	    	      RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
 	    	      requestDispatcher.include(request, response);
 	                   }
                else {
//                     response.sendRedirect("notregister");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("notregister");
                 requestDispatcher.include(request, response);
                 }
          try {
        	   if(  connection !=null  ) {
        	  connection.close();
        	   }
        	   if(   res !=null ) {
		     res.close();
        	   }
        	   if(  prStatement !=null     ) {
		     prStatement.close();
        	   }
        	   if(   pw !=null     ) {
			 pw.close();
        	   }
			 System.out.println("All  are Closed....");
		   } catch (SQLException e) {
			  e.printStackTrace();
		}
   }
}

