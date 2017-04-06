package org.javahd.springhib.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.javahd.springhib.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository("empDAO")

public class EmployeeDAOImpl {

	@Autowired
	SessionFactory sessionFactory;
	Transaction tx = null;

	public void addEmployee(Employee emp) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	public List<Employee> showAllEmployees() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		return list;

	}

	public void updateEmployee(Employee emp) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(emp);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	public void deleteEmployee(String empId) {
		System.out.println(empId);
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("delete from Employee where empno = :x");
			query.setString("x", empId);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			System.out.println("Employee Deleted!!");
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> searchEmpbyId(String empId){
		List<Employee> list = null;
		try {
			Session session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Employee.class).add(Restrictions.eq("empno", empId));
			list = c.list();
			//System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
