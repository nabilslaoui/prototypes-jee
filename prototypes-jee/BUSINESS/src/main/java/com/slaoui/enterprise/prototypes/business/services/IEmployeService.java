package com.slaoui.enterprise.prototypes.business.services;

import java.util.List;

import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

/**
 * 
 * Test Commit GIT
 * 
 * @author a555812
 *
 */
public interface IEmployeService {

	/**
	 * 
	 * cherche un employe par son identifiant fourni en paramètre
	 * 
	 * @param id
	 *            : identifiant de l'employe
	 * @return
	 */
	public EmployeAnnotated getEmployeById(int id);

	/**
	 * 
	 * @param login
	 * @return
	 */
	public EmployeAnnotated getEmployeByLogin(String login);

	/**
	 * 
	 * @param employe
	 */
	public void saveEmploye(EmployeAnnotated employe);

	/**
	 * 
	 * @return
	 */
	public int getEmployesCount();

	/**
	 * 
	 * @return
	 */
	public List<EmployeAnnotated> getAllEmployes();
	
	/**
	 * 
	 * @return
	 */
	public void delete(Long id);

}
