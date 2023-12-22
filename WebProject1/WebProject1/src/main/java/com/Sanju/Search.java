package com.Sanju;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet1")
public class Search extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4349613088249132055L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		            String username = request.getParameter("Name");
		             response.sendRedirect("https://www.google.co.in/search?q=" + username);
	}

}
