package com.niit.skillmapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.skillmapper.dao.EmployeeDao;
import com.niit.skillmapper.model.Employee;
@Repository
public  class EmployeeServicesImplementation implements EmployeeServices{
	@Autowired
	EmployeeDao employeeDao;
	public boolean registerNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		return employeeDao.registerNewEmployee(employee);
	}

	/*public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	
	}

	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(employee);
		
	}

	public Employee displayEmployeeDetails(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.displayEmployeeDetails(employeeId);
	}

	public boolean validateEmployee(String mailId, String password) {
		// TODO Auto-generated method stub
		return employeeDao.validateEmployee(mailId, password);
		
	}

	public List<Employee> displayAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.displayAllEmployees();
		
	}
	*/
	

}
