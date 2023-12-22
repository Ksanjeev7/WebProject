package com.Sanju;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class Program2 extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String name=request.getParameter("Name");
		        PrintWriter out = response.getWriter();
		            out.println(name+"Welcome servlet2");
}

}
