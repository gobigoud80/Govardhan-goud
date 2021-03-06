package com.niit.skillmapper.configuration;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.skillmapper.model.Employee;
import com.niit.skillmapper.service.EmployeeServices;
import com.niit.skillmapper.service.EmployeeServicesImplementation;
import com.niit.skillmapper.dao.EmployeeDao;
import com.niit.skillmapper.dao.EmployeeDaoImplementation;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class EmployeeConfiguration {
	
	@Bean(name="dataSource")
    public DataSource getDataSource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/term");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    private Properties getHibernateProperties(){
       Properties properties=new Properties();
       properties.setProperty("hibernate.show_sql","true");
       properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
       properties.setProperty("hibernate.hbm2ddl.auto","update");
    	
	return properties;
    }

    @Autowired
    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource){
       LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
       sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(Employee.class);
       return sessionBuilder.buildSessionFactory();
    }
    @Autowired
    @Bean(name="transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
       HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	return transactionManager;
    }
    @Autowired
    @Bean("employeeServices")
    public EmployeeServices getEmployeeService()
    {
    return new EmployeeServicesImplementation();
    }
  
}
