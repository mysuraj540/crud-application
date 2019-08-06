package com.ems.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginPage extends HttpServlet {
	
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(uname.equals("suraj") && pass.equals("suraj123")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			//response.sendRedirect("view.html");
			RequestDispatcher rd = request.getRequestDispatcher("ViewEmployee");
			rd.forward(request, response);
		}
		else {
			
			response.sendRedirect("loginError.html");
		}
	}

}
