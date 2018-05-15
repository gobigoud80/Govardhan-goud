package com.niit.skillmapper.testcases;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.service.EmployeeServices;
import com.niit.skillmapper.service.EmployeeServicesImplementation;

public class EmployeeServicesTest {

	@Autowired
	EmployeeServices employeeServices;
	// EmployeeServices employeeService;
	@Before
	public  void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		employeeServices=(EmployeeServices)context.getBean("employeeServices");
		
		/*Employee employee=new Employee();
		employee.setEmployeeId(1001);
		employee.setFirstName("Govardhan Goud");
		employee.setLastName("Goud");
		employee.setMailId("gobigoud80@gmail.com");
		employee.setPassWord("gobigoud");
		employee.setEmployeeRole("Developer");
		employee.setPhoneNumber(9959282292l);
		employee.setGender("Male");
		employeeServices.registerNewEmployee(employee);*/
		
	}
	
	@Test
	public void registerNewEmployeeTestCase() {
		Employee employee=new Employee();
		employee.setEmployeeId(1001);
		employee.setFirstName("Govardhan Goud");
		employee.setLastName("Goud");
		employee.setMailId("gobigoud80@gmail.com");
		employee.setPassWord("gobigoud");
		employee.setEmployeeRole("Developer");
		employee.setPhoneNumber(9959282292l);
		employee.setGender("Male");
		
		assertEquals("Inserted Successful", true, employeeServices.registerNewEmployee(employee));
		
		
		
		
	}

}
