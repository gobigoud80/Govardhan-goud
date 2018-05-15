

package com.niit.skillmapper.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillmapper.model.Employee;
@Repository("employeeDao")
public  class EmployeeDaoImplementation implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;
	//Session session=sessionFactory.getCurrentSession();
	//Employee employee=new Employee();
	
	@Transactional
	public boolean registerNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

    
	@Transactional
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	@Transactional
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
	       sessionFactory.getCurrentSession().delete(employee);
		return true;
		
	}

	@Transactional
	public Employee displayEmployeeDetails(int employeeId) {
		// TODO Auto-generated method stub
		Employee employee=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		return employee;
	}

	@Transactional
	public boolean validateEmployee(String mailId, String passWord) {
		// TODO Auto-generated method stub
	
		return true;
	}

	@Transactional
	public List<Employee> displayAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
				}

}
