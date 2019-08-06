package com.ems.dao;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeDao {
		public boolean employeeRegistration(Employee e);
		public List<Employee> getEmployee();
		public int deleteEmployee(String firstName);
		public boolean updateEmployee(Employee e);
		public Employee updateEmployee(String firstName);
}
