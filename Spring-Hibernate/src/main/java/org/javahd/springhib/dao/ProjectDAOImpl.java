package org.javahd.springhib.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.javahd.springhib.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("projDAO")
public class ProjectDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	Transaction tx = null;
	
	public void addProject(Project proj) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(proj);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Project> showAllProjects() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Project");
		List<Project> list = query.list();
		return list;

	}

	public void updateProject(Project proj) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(proj);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	public void deleteProject(String projId) {
		//System.out.println(projId);
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("delete from Project where projid = :x");
			query.setString("x", projId);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			System.out.println("Project Deleted!!");
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getProjbyId(String projId){
		List<Project> list = null;
		try {
			Session session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Project.class).add(Restrictions.eq("projid", projId));
			list = c.list();
			//System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
