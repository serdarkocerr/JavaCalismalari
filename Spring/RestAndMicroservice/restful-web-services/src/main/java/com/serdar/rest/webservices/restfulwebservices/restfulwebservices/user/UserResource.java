package com.serdar.rest.webservices.restfulwebservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import  static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	
	@Autowired
	private UserDaoService userDaoService;
	
	//GET /users
	// retriveAllUsers
	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
		
		return userDaoService.findAll();
		
	}
	
	
	//EntityModel for HATEOS 
	//retriveUser(int id)
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		
		User user;
			user = userDaoService.findOne(id);
			
			if(user == null)
				throw new UserNotFoundException("id-"+id);
		
		EntityModel<User> model = EntityModel.of(user);
		 
		//add "/users" link to returned JSOn object.
		WebMvcLinkBuilder linkToUser = 
				linkTo(methodOn(this.getClass()).retriveAllUsers());
		
		model.add(linkToUser.withRel("all-users"));
		
		
		return model;
	}
	
	//input - detail of user
	//output CREATED & Retur the created URI
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		
		 User savedUser = userDaoService.save(user);
		 
		 //return status as created and saveduser.getid
		 
		 URI location = ServletUriComponentsBuilder
		 	.fromCurrentRequest()
		 	.path("/{id}")
		 	.buildAndExpand(savedUser.getId())
		 	.toUri();
		 
		 
		 return ResponseEntity.created(location).build();
		
	}
	
	
	//retriveUser(int id)
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = userDaoService.deleteById(id);
		
			if(user == null)
				throw new UserNotFoundException("id-"+id);
		
	}

}
