package com.ems.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bao.EmployeeBOImpl;
import com.ems.model.Employee;

/**
 * Servlet implementation class ViewEmployee
 */
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		 //pw.println("<a href='addNew.html'>Add New Employee</a>");
		EmployeeBOImpl bo=new EmployeeBOImpl();
		List<Employee> employeeList=bo.getEmployee();
		if(employeeList.size()==0){
		
		pw.println("No Employee Record Found");
		}
		else{
			response.setContentType("text/html");
			pw.println("<html>"
					+"<head>"
					+"<title>Show employee</title>"
					+"</head>"
					+"<body bgcolor = \"cyan\">\r\n"
					
					+"     <table border =\"2\" cellpadding=\"2\" width=\"40%\" background=\"transparent\" align=\"center\"\r\n" + 
					"      \r\n" + 
					"        cellspacing=\"2\">\r\n" + 
					"      \r\n" + 
					"      \r\n" +
					"      <tr>\r\n" + 
					//"      <a href='addNew.html'>Add New Employee</a>"+
					"      </tr>\r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					//"        <td colspan=2>\r\n" + 
					"      \r\n" + 
					"        <center><font color=\"blue\"size=6><b>Employee Details</b></font></center>\r\n" + 
					"      \r\n" +
					//"        </td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" +
					"      <tr>\r\n" + 
					"        <td colspan=1>\r\n" +
					"      <a href=\"addNew.html\">\r\n" + 
					"			<input type=\"button\" value=\"Add New\">\r\n" + 
					"		</a>"+
					"        </td>\r\n" + 
					"      </tr>\r\n" +
					"      \r\n" + 
					"      \r\n" 
					+"<th>First Name</th><th>Last Name</th><th>Age</th><th>Salary</th><th>Department</th><th>State</th><th>City</th><th>Skills</th><th>Edit</th><th>Delete</th>"
					+"</tr>");
					for(Employee e:employeeList){
					pw.print("<tr>"
							+"<td>"+e.getFirstName()+"</td>"
							+"<td>"+e.getLastName()+"</td>"
							+ "<td>"+e.getAge()+"</td>"
							+ "<td>"+e.getSalary()+"</td>"
							+ "<td>"+e.getDepartment()+"</td>"
							+ "<td>"+e.getState()+"</td>"
							+ "<td>"+e.getCity()+"</td>"
							+ "<td>"+e.getSkills()+"</td>"+"<td><a href='UpdateEmployee?firstName="+e.getFirstName()+"'>edit</a></td>"
			                +"<td><a href='DeleteEmployee?firstName="+e.getFirstName()+"'>delete</a></td></tr>"
			                );
			                }
					pw.println("</table>"
					            +"</body>"
	             				+"</html>");
	}
	}

}
