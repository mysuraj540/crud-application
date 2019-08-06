package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.bao.EmployeeBO;
import com.ems.bao.EmployeeBOImpl;
import com.ems.model.Employee;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		System.out.println(firstName);
		EmployeeBO bo=new EmployeeBOImpl();
		Employee e=new Employee();
		e=bo.updateEmployee(firstName);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if(e!=null){
			//System.out.println(e.getFirstName());
			pw.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"\r\n" + 
					" <script type=\"text/javascript\">\r\n" + 
					"        function populate(s1,s2){\r\n" + 
					"            var s1= document.getElementById(s1);\r\n" + 
					"            var s2= document.getElementById(s2)\r\n" + 
					"            s2.innerHTML = \"\";\r\n" + 
					"            if(s1.value == \"Karnatka\"){\r\n" + 
					"                var optionArray = [\"|\",\"bengaluru|Bengaluru\",\"mysore|Mysore\",\"belgaum|Belgaum\"];\r\n" + 
					"                \r\n" + 
					"            } else if(s1.value == \"TamilNadu\"){\r\n" + 
					"                var optionArray = [\"|\",\"chennai|Chennai\",\"ooty|Ooty\",\"madurai|Madurai\"];\r\n" + 
					"                \r\n" + 
					"            } else if(s1.value == \"Maharashtra\"){\r\n" + 
					"                var optionArray = [\"|\",\"mumbai|Mumbai\",\"pune|Pune\",\"nagpur|Nagpur\"];\r\n" + 
					"                \r\n" + 
					"            }\r\n" + 
					"            for(var option in optionArray){\r\n" + 
					"                var pair = optionArray[option].split(\"|\");\r\n" + 
					"                var newOption = document.createElement(\"option\");\r\n" + 
					"                newOption.value = pair[0];\r\n" + 
					"                newOption.innerHTML = pair[1];\r\n" + 
					"                s2.options.add(newOption);\r\n" + 
					"            }\r\n" + 
					"        }\r\n" + 
					"        </script>\r\n" + 
					"\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"</head>\r\n" + 
					"<body bgcolor = \"cyan\">\r\n" + 
					"\r\n" + 
					"        <form action=\"EditEmployee\">\r\n" + 
					"      \r\n" + 
					"        <table cellpadding=\"2\" width=\"40%\" background=\"transparent\" align=\"center\"\r\n" + 
					"      \r\n" + 
					"        cellspacing=\"2\">\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td colspan=2>\r\n" + 
					"      \r\n" + 
					"        <center><font size=6><b>Employee Registration Form</b></font></center>\r\n" + 
					"      \r\n" + 
					"        </td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>First Name</b></td>\r\n" + 
					"      \r\n" + 
					"        <td><input type=\"text\" name=\"firstName\" size=\"50\" value='"+e.getFirstName()+"'></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      <br>\r\n" + 
					"      <br>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>Last Name</b></td>\r\n" + 
					"      \r\n" + 
					"        <td><input type=\"text\" name=\"lastName\"  size=\"50\" value='"+e.getLastName()+"'></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>Age</b></td>\r\n" + 
					"      \r\n" + 
					"        <td><input type=\"number\" name=\"age\" min=\"\" max=\"\" value='"+e.getAge()+"'></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>Salary</b></td>\r\n" + 
					"      \r\n" + 
					"        <td><input type=\"number\" name=\"salary\" min=\"\" max=\"\" value='"+e.getSalary()+"'></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>Gender</b></td>\r\n" + 
					"      \r\n" + 
					"        <td>\r\n" + 
					"        <input type=\"radio\" name=\"gender\" value=\"Male\" size=\"14\">Male\r\n" + 
					"      \r\n" + 
					"        <input type=\"radio\" name=\"gender\" value=\"Female\" size=\"14\">Female\r\n" + 
					"        </td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>Department</b></td>\r\n" + 
					"      \r\n" + 
					"        <td><select name=\"department\">\r\n" + 
					"      \r\n" + 
					"        <option value=\"-1\" selected>select..</option>\r\n" + 
					"      \r\n" + 
					"        <option value=\"SWG\">SWG</option>\r\n" + 
					"      \r\n" + 
					"        <option value=\"IT\">IT</option>\r\n" + 
					"      \r\n" + 
					"        <option value=\"Finance\">Finance</option>\r\n" + 
					"      \r\n" + 
					"        </select></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>State</b></td>\r\n" + 
					"      \r\n" + 
					"        <td> <select id=\"select1\" name=\"state\" onchange=\"populate(this.id,'select2')\">\r\n" + 
					"            <option value=\"\"></option>\r\n" + 
					"            <option value=\"Karnatka\">Karnatka</option>\r\n" + 
					"            <option value=\"TamilNadu\">TamilNadu</option>\r\n" + 
					"            <option value=\"Maharashtra\">Maharashtra</option>\r\n" + 
					"    \r\n" + 
					"        </select></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>City</b></td>\r\n" + 
					"      \r\n" + 
					"        <td><select id=\"select2\" name=\"city\"></select></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>Skill</b></td>\r\n" + 
					"      \r\n" + 
					"        <td>\r\n" + 
					"        <input type=\"checkbox\" name=\"skills\" value=\"Java\">\r\n" + 
					"        <label for=\"java\">Java</label>\r\n" + 
					"      \r\n" + 
					"        <input type=\"checkbox\" name=\"skills\" value=\"J2ee\">\r\n" + 
					"        <label for=\"java\">J2ee</label>\r\n" + 
					"      \r\n" + 
					"        <input type=\"checkbox\" name=\"skills\" value=\"Spring\">\r\n" + 
					"        <label for=\"java\">Spring</label>\r\n" + 
					"      \r\n" + 
					"        <input type=\"checkbox\" name=\"skills\" value=\"Sql\">\r\n" + 
					"        <label for=\"java\">Sql</label>\r\n" + 
					"        </td>\r\n" + 
					"      \r\n" + 
					"      </tr> \r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td><b>Address</b></td>\r\n" + 
					"      \r\n" + 
					"        <td>\r\n" + 
					"        <textarea rows=\"4\" cols=\"50\" name = \"address\" placeholder=\"Enter Address\">\r\n" + 
					"        </textarea>\r\n" + 
					"        </td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"      \r\n" + 
					"      <tr>\r\n" + 
					"      \r\n" + 
					"        <td colspan=center><input type=\"submit\" value=\"Save\"/></td>\r\n" + 
					"      \r\n" + 
					"        <td><input type=\"reset\" value=\"clear\"></td>\r\n" + 
					"      \r\n" + 
					"      </tr>\r\n" + 
					"      \r\n" + 
					"        </table>\r\n" + 
					"      \r\n" + 
					"        </form>\r\n" + 
					"      \r\n" + 
					"        </body>\r\n" + 
					"</html>");
					}
					else {
					pw.println("No employee found ");
					}
	}
}
