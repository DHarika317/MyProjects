package org.javahd.springhib;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.javahd.springhib.dao.EmployeeDAOImpl;
import org.javahd.springhib.dao.ProjectDAOImpl;
import org.javahd.springhib.entity.Employee;
import org.javahd.springhib.entity.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring.xml");

		Project p1 = new Project("1", "Library Management Software", 6);
		Project p2 = new Project("2", "U.S Census", 12);
		Employee e1 = new Employee("1", "Harika", "Java Developer", 65000, new Date());
		Employee e2 = new Employee("2", "Hannah", "Data Analyst", 55634, new Date());
		Employee e3 = new Employee("3", "Steve", "Senior Java Developer", 105000, new Date());

		
		ProjectDAOImpl projectDao = (ProjectDAOImpl) cxt.getBean("projDAO");
		projectDao.addProject(p1);
		projectDao.addProject(p2);
		List<Project> plist = projectDao.showAllProjects();
		for (Project p : plist) {
			System.out.println(p);
		}
		
		List<Project> pr = projectDao.getProjbyId("1");
		for (Project p : pr) {
			System.out.println(p);
			e3.setProject(p);
		}
		e1.setProject(p1);
		e2.setProject(p2);
		
		EmployeeDAOImpl employeeDao = (EmployeeDAOImpl) cxt.getBean("empDAO");
		employeeDao.addEmployee(e1);
		employeeDao.addEmployee(e2);
		employeeDao.addEmployee(e3);
		List<Employee> list = employeeDao.showAllEmployees();
		for (Employee e : list) {
			System.out.println(e);
		}
		// employeeDao.deleteEmployee("1");
		// List<Employee> list2 = employeeDao.showAllEmployees();
		// for(Employee e: list2){
		// System.out.println(e);
		// }
		// employeeDao.updateEmployee(new Employee("2", "Hannah", "Data
		// Analyst", 56000, new Date()));
		// List<Employee> list3 = employeeDao.searchEmpbyId("2");
		// for (Employee e : list3) {
		// System.out.println(e);
		// }
	}
}
