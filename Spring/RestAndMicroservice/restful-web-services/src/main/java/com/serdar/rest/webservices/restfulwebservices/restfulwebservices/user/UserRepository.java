package com.serdar.rest.webservices.restfulwebservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//retrive data using JPA from H2
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{//entity(table) name and id

	
	
}
