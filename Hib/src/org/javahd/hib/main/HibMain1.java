package org.javahd.hib.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.javahd.hib.entity.Address;
import org.javahd.hib.entity.DepartmentInfo;
import org.javahd.hib.entity.Employee;
import org.javahd.hib.entity.Project;


public class HibMain1 {

	public static void main(String[] args) {
		//1. Get the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure();
		//2. create a session factory to store session objects
		ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionfactory = configuration.buildSessionFactory(serviceregistry);
		Session session = sessionfactory.openSession();
		//3. Store model objects (Employee class) in session, to do this first begin the transaction
		session.beginTransaction();
		
		Employee emp1 = new Employee("1", "Joey", "Recruiter", 43156, new Date());
		Employee emp2 = new Employee("2", "John", "Accountant", 55475, new Date());
//		Address ad1 = new Address("112N Walnut ave", "95", "Cary", "North Carolina", "27614");
		DepartmentInfo dept1 = new DepartmentInfo("1","HR");
		Project proj1 = new Project("1","Re-deploy HR Dept", 3);
		Project proj2 = new Project("2","IT Development",4);
		Project proj3 = new Project("3","Liablility Checks", 4);
		
		emp1.getProject().add(proj1);
		emp1.getProject().add(proj2);
//		emp1.setAddress(ad1);
		emp1.setDepartment(dept1);
		emp2.getProject().add(proj3);
		
		session.save(emp1);
		session.save(emp2);
		session.save(proj1);
		session.save(proj2);
		session.save(proj3);
		session.save(dept1);
		session.getTransaction().commit();
		session.close();

	}

}
