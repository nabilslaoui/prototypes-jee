package com.slaoui.enterprise.prototypes.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.slaoui.enterprise.prototypes.business.services.IEmployeService;
import com.slaoui.enterprise.prototypes.dao.IEmployeDao;
import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

@Service("empService")
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	@Qualifier("exempleHibernate2")
	private IEmployeDao dao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeById(int id) {
		return dao.getEmployeById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeByLogin(String login) {
		return dao.getEmployeByLogin(login);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveEmploye(EmployeAnnotated employe) {
		dao.saveEmploye(employe);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getEmployesCount() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeAnnotated> getAllEmployes() {
		return dao.getAllEmployes();
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

}
