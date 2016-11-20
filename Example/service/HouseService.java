package service;

import java.util.List;
import controller.HouseController;
import entity.House;

//Imports padrão para o WS poder funcionar
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericEntity;

@Path("/UserService")//Url chamada no WS
public class HouseService {

	HouseController userController = new HouseController();

	@GET
	@Path("/users")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<House> getUsers(){
	   return userController.getAllUsers();
	}
	   
	@GET
	@Path("/usersJson")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GenericEntity<List<House>> getUsersJson(){
		return new GenericEntity<List<House>>(userController.getAllUsers()) {};
	}
}

/* EXEMPLOS
 * http://coenraets.org/blog/2011/11/building-restful-services-with-java-using-jax-rs-and-jersey-sample-application/
 * 
 **/