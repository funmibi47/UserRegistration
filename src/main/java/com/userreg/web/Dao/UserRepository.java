package com.userreg.web.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userreg.web.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 
	
	 @Query("SELECT u FROM User u WHERE u.activation_token = ?1")
	    public User findByActivation_token(String token);
}
