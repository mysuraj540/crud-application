package com.ems.bao;

import java.util.List;

import com.ems.dao.EmployeeDaoImpl;
import com.ems.model.Employee;

public class EmployeeBOImpl implements EmployeeBO{

	@Override
	public boolean employeeRegistration(Employee e) {
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		boolean bl=dao.employeeRegistration(e);
		return bl;
		
	}

	@Override
	public List<Employee> getEmployee() {
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		List<Employee> employeeList=dao.getEmployee();
		return employeeList;
	}

	@Override
	public int deleteEmployee(String firstName) {
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		int count=dao.deleteEmployee(firstName);
		return count;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		boolean bl=dao.updateEmployee(e);
		return bl;
	}

	@Override
	public Employee updateEmployee(String firstName) {
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		Employee e=dao.updateEmployee(firstName);
		return e;
	}
	

}
