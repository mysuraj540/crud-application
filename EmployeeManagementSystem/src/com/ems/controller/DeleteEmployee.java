package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bao.EmployeeBO;
import com.ems.bao.EmployeeBOImpl;

/**
 * Servlet implementation class DeleteEmployee
 */
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		EmployeeBO bo=new EmployeeBOImpl();
		int count=bo.deleteEmployee(firstName);
		PrintWriter pw=response.getWriter();
		if(count!=0){
			//pw.println(count+" Employee Details "+firstName+" deleted Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ViewEmployee");
			rd.forward(request, response);
		}
		else{
			pw.println("Falid To Delete");
		}	
	}

}
