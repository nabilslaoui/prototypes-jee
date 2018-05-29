
package com.slaoui.enterprise.prototypes.rest.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slaoui.enterprise.prototypes.business.services.IEmployeService;
import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

/**
 * 
 * @author utilisateur
 *
 */
@Path("/manageEmploye")
public class EmployeServiceRestJAXRS {

	@Autowired
	private IEmployeService employeService;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * 
	 * @return
	 */
	@POST
	@Path("/createEmploye")
	@Consumes("application/json")
	public Response createEmploye(EmployeAnnotated employe) {
		employeService.saveEmploye(employe);
		return Response.status(Status.CREATED).build();
	}

	/**
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/getAllEmployes")
	@Produces("application/json")
	public Response getAllEmployes() throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(employeService.getAllEmployes());
		return Response.ok(json).build();
	}

	/**
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/getEmployeById/{id}")
	@Produces("application/json")
	public Response getAllEmployeById(@PathParam("id") Integer id) throws JsonProcessingException {
		EmployeAnnotated employe = employeService.getEmployeById(id);
		String employeAsJSON = objectMapper.writeValueAsString(employe);
		return Response.ok(employeAsJSON).build();
	}

	/**
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/getAllEmployeById/{login}")
	@Produces("application/json")
	public Response getAllEmployeByLogin(@PathParam("login") String login) throws JsonProcessingException {
		EmployeAnnotated employe = employeService.getEmployeByLogin(login);
		String employeAsJSON = objectMapper.writeValueAsString(employe);
		return Response.ok(employeAsJSON).build();
	}

}
