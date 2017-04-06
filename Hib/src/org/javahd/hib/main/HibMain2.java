package org.javahd.hib.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.javahd.hib.entity.Address;
import org.javahd.hib.entity.DepartmentInfo;
import org.javahd.hib.entity.Employee;
import org.javahd.hib.entity.Project;


public class HibMain2 {

	public static void main(String[] args) {
		//1. Get the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure();
		//2. create a session factory to store session objects
		ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionfactory = configuration.buildSessionFactory(serviceregistry);
		Session session = sessionfactory.openSession();
		// DML operations using Hibernate Query language
		Query query = session.createQuery("from Employee");
		Query query2 = session.createQuery("from Employee where job=?");
		query2.setString(0, "Recruiter");
		// DML operations using SQL
		//SQLQuery query = session.createSQLQuery("Select * from emp_table"); 
		//query.addEntity(Employee.class);
		System.out.println("List of Employees:");
		List<Employee> list = query.list();
		for(Employee e: list){
			System.out.println(e);
		}
		System.out.println("List of Recruiters");
		List<Employee> list2 = query2.list();
		for(Employee e: list2){
			System.out.println(e);
		}
		session.close();

	}

}
