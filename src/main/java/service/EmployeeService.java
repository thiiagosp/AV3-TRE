package service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericEntity;

import controller.EmployeeController;
import entity.Employee;

@Path("/EmployeeService")//Url chamada no WS
public class EmployeeService {

	EmployeeController employeeController = new EmployeeController();
	
	@GET
	@Path("/login")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee loginEmployee(List<String> CodeAndPassword){
		return employeeController.Login(CodeAndPassword.get(0), CodeAndPassword.get(1));
	}
	
}
