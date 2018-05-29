package com.slaoui.enterprise.prototypes.dao;

import java.util.List;

import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

/**
 * 
 * @author nabil slaoui <nabil.slaoui@atos.net>
 *
 */
public interface IEmployeDao {

	/**
	 * 
	 * @param id
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
	
	
	public void delete(Long id);

}
