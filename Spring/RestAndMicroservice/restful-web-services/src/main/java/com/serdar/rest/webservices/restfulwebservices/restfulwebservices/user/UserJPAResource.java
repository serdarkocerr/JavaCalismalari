package com.serdar.rest.webservices.restfulwebservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	//GET /users
	// retriveAllUsers
	@GetMapping(path = "/jpa/users")
	public List<User> retriveAllUsers() {
		
		return userRepository.findAll();
		
	}
	
	
	//EntityModel for HATEOS 
	//retriveUser(int id)
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		
		Optional<User> user;
			user = userRepository.findById(id);
			
			if(!user.isPresent())
				throw new UserNotFoundException("id-"+id);
		
		EntityModel<User> model = (EntityModel<User>) EntityModel.of(user.get());
		 
		//add "jpa/users" link to returned JSOn object.
		WebMvcLinkBuilder linkToUser = 
				linkTo(methodOn(this.getClass()).retriveAllUsers());
		
		model.add(linkToUser.withRel("all-users"));
		
		
		return model;
	}
	
	//input - detail of user
	//output CREATED & Retur the created URI
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		
		 User savedUser = userRepository.save(user);
		 
		 //return status as created and saveduser.getid
		 
		 URI location = ServletUriComponentsBuilder
		 	.fromCurrentRequest()
		 	.path("/{id}")
		 	.buildAndExpand(savedUser.getId())
		 	.toUri();
		 
		 
		 return ResponseEntity.created(location).build();
		
	}
	
	
	//retriveUser(int id)
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = userRepository.findById(id).get();
		
			if(user == null)
				throw new UserNotFoundException("id-"+id);
			
			userRepository.delete(user);
	}
	
	//retrive posts for user
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retriveAllUserPosts(@PathVariable int id){
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("id-"+id);

		
		return userOptional.get().getPosts();
	}
	
	
	//save posts for user
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
		
		Optional<User> userOpt = userRepository.findById(id);
		
		if(!userOpt.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		User user = userOpt.get();
		post.setUser(user);
		
		//save to post table
		postRepository.save(post);
		
		 
		 URI location = ServletUriComponentsBuilder
		 	.fromCurrentRequest()
		 	.path("/{id}")
		 	.buildAndExpand(post.getId())
		 	.toUri();
		 
		 
		 return ResponseEntity.created(location).build();//returning that  post created URI
		
	}
	
}
