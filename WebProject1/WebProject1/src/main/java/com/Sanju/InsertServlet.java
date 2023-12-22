package com.Sanju;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Save")
public class InsertServlet extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
static 	Employeebo empob = new Employeebo();
// static EmployeeDao emp;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int Id = Integer.parseInt(request.getParameter("Id"));
		String Ename = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String dept = request.getParameter("Department");
		int salary = Integer.parseInt(request.getParameter("salary"));
		EmployeeDao emp = new EmployeeDao(Id, Ename, Email, dept, salary);
		 int emps = empob.InsertEmp(emp);
		 if(emps>0) {
			 out.println("<h2 style='color:Green'>Employee data Saved Successfully......</h2>");
			 RequestDispatcher dispatcher = request.getRequestDispatcher("Form.html");
			 dispatcher.include(request, response);			 
		 }else {
			 out.println("<h2 Style='Color:Red'>Sorry!! Data Not saved....");
		 }
		 out.close();
	}
	        
}


		
		
		
		
		
		
		
		
		 


