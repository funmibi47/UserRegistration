package com.userreg.web.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.userreg.web.Dao.UserRepository;
import com.userreg.web.Model.User;
import com.userreg.web.Service.UserService;
 
 

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class AppController {

	@Autowired
	private UserService service;
	
 
//	save user information
 
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		
		 
		String random_string = getRandom();
		 user.setActive(false);
		 user.setActivation_token(random_string);
		 
		service.save(user);
		 
		return user;
	}
	 
	 
	// activate user
	@GetMapping("/user/{token}")
	public ResponseEntity<User> getUserByToken(@PathVariable(value = "token") String token)
	    {
	    User user = service.findByActivation_token(token);
	    if(user == null) {
	    	
	    }
	    else {
	    	 user.setActive(true);
	    	 user.setActivation_token("");
	    	 service.save(user);
	    }
	       
	    return ResponseEntity.ok().body(user);
	}
	
	
	
	public String getRandom() {
		// create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 7;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    return randomString;
	}
	 
	 
	
	 
}
