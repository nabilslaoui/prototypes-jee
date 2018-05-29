package com.slaoui.enterprise.prototypes.springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.slaoui.enterprise.prototypes.business.services.IEmployeService;
import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

/**
 * 
 * @author a555812
 *
 */
@RestController
@RequestMapping(value = "/employe")
@EnableAutoConfiguration
public class EmployeController {

	@Autowired
	private IEmployeService employeService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<EmployeAnnotated> list() {
		return employeService.getAllEmployes();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody EmployeAnnotated getById(@PathVariable int id) {
		return employeService.getEmployeById(id);
	}

	/**
	 * 
	 * @param employe
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void create(@RequestBody EmployeAnnotated employe) {
		employeService.saveEmploye(employe);
	}

	/**
	 * 
	 * @param employe
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		employeService.delete(id);
	}

}
