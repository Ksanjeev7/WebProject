package com.Sanju;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/notregister")
public class Blocked extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 6807227552978664429L;

@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String un =  request.getParameter("Name");
       PrintWriter   pw = response.getWriter();
       pw.println( un +"<h2 style='color:red'>Sorry Your not Registered....Contact Admin</h2>");
       pw.close();
    }
}
