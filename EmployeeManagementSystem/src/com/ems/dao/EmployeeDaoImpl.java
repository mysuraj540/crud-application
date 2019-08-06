package com.ems.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ems.dbutil.DBConnection;
import com.ems.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public boolean employeeRegistration(Employee e) {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
			String sql = "insert into employeedata values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, e.getFirstName());
			pstmt.setString(2, e.getLastName());
			pstmt.setInt(3, e.getAge());
			pstmt.setInt(4, e.getSalary());
			pstmt.setString(5, e.getGender());
			pstmt.setString(6, e.getDepartment());
			pstmt.setString(7, e.getState());
			pstmt.setString(8, e.getCity());
			pstmt.setString(9, e.getSkills());
			pstmt.setString(10, e.getAddress());
			
			int status = pstmt.executeUpdate();
			if (status != 0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getEmployee() {
		Connection connection = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			connection = DBConnection.getConnection();
			String sql = "Select * from employeedata";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				Employee e = new Employee();
				e.setFirstName(res.getString("firstName"));
				e.setLastName(res.getString("lastName"));
				e.setAge(res.getInt("age"));
				e.setSalary(res.getInt("salary"));
				e.setDepartment(res.getString("department"));
				e.setState(res.getString("state"));
				e.setCity(res.getString("city"));
				e.setSkills(res.getString("skills"));
				
				employeeList.add(e);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public int deleteEmployee(String firstName) {
		int count =0;
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
			String sql = "delete from employeedata where firstName=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, firstName);
		    count = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
			String sql = "UPDATE EMPLOYEEDATA SET FIRSTNAME=?, LASTNAME=?, AGE=?, SALARY=?, GENDER=?, DEPARTMENT=?, STATE=?, CITY=?, SKILLS=?, ADDRESS=? WHERE FIRSTNAME='"+e.getFirstName()+"'";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, e.getFirstName());
			pstmt.setString(2, e.getLastName());
			pstmt.setInt(3, e.getAge());
			pstmt.setInt(4, e.getSalary());
			pstmt.setString(5, e.getGender());
			pstmt.setString(6, e.getDepartment());
			pstmt.setString(7, e.getState());
			pstmt.setString(8, e.getCity());
			pstmt.setString(9, e.getSkills());
			pstmt.setString(10, e.getAddress());
			
			int status=pstmt.executeUpdate();
			if (status != 0) {
				return true;
			}

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee updateEmployee(String firstName) {
		System.out.println(firstName);
		Employee e=new Employee();
		try {
			Statement stmt = (DBConnection.getConnection()).createStatement();
			ResultSet res = stmt.executeQuery("SELECT *FROM EMPLOYEEDATA WHERE FIRSTNAME='"+firstName+"'");
			if (res.next()) {
				e = new Employee(res.getString("firstName"), res.getString("lastName"), res.getInt("age"),
						res.getInt("salary"),res.getString("gender"),res.getString("department"),res.getString("state"),
						res.getString("city"),res.getString("skills"),res.getString("address"));
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
		}
		return e;
	}


}
