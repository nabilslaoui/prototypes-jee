package com.slaoui.enterprise.prototypes.dao.springhibernate.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.slaoui.enterprise.prototypes.dao.IEmployeDao;
import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

/*
 * Version d'HibernateEmployeDAO en utilisant un Template Hibernate
 * Avantage : services rendus par le Template (gestion exceptions, API bas niveau...)
 * Inconvenient : code spring intrusif
 */
@Repository("exempleHibernate2")
public class HibernateEmployeDao implements IEmployeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/*
	 * Meilleure pratique utilisation HibernateTemplate dans un DAO: La Hibernate
	 * Template est injectée au DAO lors de la création de ce dernier . Paramétrage
	 * réalisé dans spring-data.xml
	 */
	public void setHibernateTemplate(HibernateTemplate template) {
		this.hibernateTemplate = template;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveEmploye(EmployeAnnotated employe) {
		Transaction t = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
		hibernateTemplate.getSessionFactory().getCurrentSession().save(employe);
		t.commit();
		hibernateTemplate.getSessionFactory().getCurrentSession().close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeById(int id) {
		Transaction t = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
		List<EmployeAnnotated> result = (List<EmployeAnnotated>) hibernateTemplate
				.find("from EmployeAnnotated where id =" + id);
		t.commit();
		hibernateTemplate.getSessionFactory().getCurrentSession().close();
		return result.get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeByLogin(String login) {
		Transaction t = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
		List<EmployeAnnotated> result = (List<EmployeAnnotated>) hibernateTemplate
				.find("from EmployeAnnotated where login =" + login);
		t.commit();
		hibernateTemplate.getSessionFactory().getCurrentSession().close();
		return result.get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeAnnotated> getAllEmployes() {
		Transaction t = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
		org.hibernate.query.Query query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("FROM EmployeAnnotated");
		List<EmployeAnnotated> result = query.list();
		t.commit();
		hibernateTemplate.getSessionFactory().getCurrentSession().close();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getEmployesCount() {
		return 0;
	}

	@Override
	public void delete(Long id) {
		EmployeAnnotated a = getEmployeById(id.intValue());

		Transaction t = hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();

		hibernateTemplate.getSessionFactory().getCurrentSession().delete(a);
		t.commit();
		hibernateTemplate.getSessionFactory().getCurrentSession().close();

	}

}
