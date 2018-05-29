package com.slaoui.enterprise.prototypes.soap.jaxws.impl;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.slaoui.enterprise.prototypes.business.services.IEmployeService;
import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;
import com.slaoui.enterprise.prototypes.soap.jaxws.CreateEmpployesRequest;
import com.slaoui.enterprise.prototypes.soap.jaxws.CreateEmpployesResponse;
import com.slaoui.enterprise.prototypes.soap.jaxws.Employe;
import com.slaoui.enterprise.prototypes.soap.jaxws.GestionEmployes;
import com.slaoui.enterprise.prototypes.soap.jaxws.GetAllEmployesRequest;
import com.slaoui.enterprise.prototypes.soap.jaxws.GetAllEmployesResponse;
import com.slaoui.enterprise.prototypes.soap.jaxws.GetEmployesByIDRequest;
import com.slaoui.enterprise.prototypes.soap.jaxws.GetEmployesByIDResponse;
import com.slaoui.enterprise.prototypes.soap.jaxws.ListEmployes;

/**
 * 
 * @author a555812
 *
 */
@WebService(name = "GestionEmploye", targetNamespace = "http://jaxws.soap.prototypes.enterprise.slaoui.com/")
public class GestionEmployeSOAPImpl implements GestionEmployes {

	@Autowired
	private IEmployeService employeService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreateEmpployesResponse createEmployes(CreateEmpployesRequest parameters) {
		for (Employe employe : parameters.getEmployes().getEmploye()) {
			EmployeAnnotated e = new EmployeAnnotated();
			e.setEmail(employe.getEmail());
			e.setLogin(employe.getLogin());
			e.setNom(employe.getNom());
			e.setPassword(employe.getPassword());
			e.setPrenom(employe.getPrenom());
			e.setRole(e.getRole());
			employeService.saveEmploye(e);
		}
		CreateEmpployesResponse response = new CreateEmpployesResponse();
		response.setErrorCode("00");
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetEmployesByIDResponse getEmployesByID(GetEmployesByIDRequest parameters) {
		GetEmployesByIDResponse response = new GetEmployesByIDResponse();
		ListEmployes value = new ListEmployes();
		for (BigInteger id : parameters.getIdEmployes().getId()) {
			EmployeAnnotated employeAnnotated = employeService.getEmployeById(id.intValue());
			Employe ee = new Employe();
			ee.setEmail(employeAnnotated.getEmail());
			ee.setLogin(employeAnnotated.getLogin());
			ee.setNom(employeAnnotated.getNom());
			ee.setPassword(employeAnnotated.getPassword());
			ee.setPrenom(employeAnnotated.getPrenom());
			ee.setRole(employeAnnotated.getRole());
			value.getEmploye().add(ee);
		}
		response.setErrorCode("00");
		response.setEmployes(value);
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetAllEmployesResponse getAllEmployes(GetAllEmployesRequest parameters) {
		List<EmployeAnnotated> employes = employeService.getAllEmployes();
		GetAllEmployesResponse response = new GetAllEmployesResponse();
		ListEmployes value = new ListEmployes();
		for (EmployeAnnotated employeAnnotated : employes) {
			Employe e = new Employe();
			e.setEmail(employeAnnotated.getEmail());
			e.setLogin(employeAnnotated.getLogin());
			e.setNom(employeAnnotated.getNom());
			e.setPassword(employeAnnotated.getPassword());
			e.setPrenom(employeAnnotated.getPrenom());
			e.setRole(e.getRole());
			value.getEmploye().add(e);
		}
		response.setEmployes(value);
		response.setErrorCode("00");
		return response;
	}

}
