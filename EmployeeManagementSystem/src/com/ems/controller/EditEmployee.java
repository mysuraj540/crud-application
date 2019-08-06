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
import com.ems.model.Employee;

/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String age=request.getParameter("age");
		String salary=request.getParameter("salary");
		String gender=request.getParameter("gender");
		String department=request.getParameter("department");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String skills=request.getParameter("skills");
		String address=request.getParameter("address");
		System.out.println(firstName+" "+lastName+" "+age+" "+salary+" "+department+" "+state+" "+city+" "+skills+" "+address);
		
		Employee employee=new Employee(firstName,lastName,Integer.parseInt(age),Integer.parseInt(salary),gender,department,state,city,skills,address);
		EmployeeBO bo=new EmployeeBOImpl();
		boolean bl=bo.updateEmployee(employee);
		if(bl==true){
			//response.sendRedirect("success.html");
			RequestDispatcher rd = request.getRequestDispatcher("ViewEmployee");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("error.html");
		}
	}


}
