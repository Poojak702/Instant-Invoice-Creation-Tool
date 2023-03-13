package com.alacriti.invoiceCreation.resource;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.service.UserService;
import com.alacriti.invoiceCreation.vo.User;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {
	
	private static Logger log = Logger.getLogger(UserResource.class.getName());  
	UserService userService = new UserService();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user) { 
		
		log.info("in userResource--->addUser Method starts.");
		return  userService.signUp(user);
	}
	
	@POST
	@Path("/{login}")
	@Produces(MediaType.APPLICATION_JSON)												
	@Consumes(MediaType.APPLICATION_JSON)
	public User getUser(User user) {			
		
		log.info("in userResource--->getUser Method starts.");
		return userService.login(user);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") int id) {
		
		log.info("in userResource--->getUserById method starts.");
		return userService.getUserById(id);
	}
	
	@PUT
	@Path("/{imagePath}")
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user) {
		
		log.info("in userResource---> updateUser starts.");
		return userService.updateProfile(user);
	}
	
	@PUT
	@Path("/edit")
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUserDetails(User user) {
		
		log.info("in userResource--->updateUserDetails starts.");
		return userService.updateUserDetails(user);
	}
}


