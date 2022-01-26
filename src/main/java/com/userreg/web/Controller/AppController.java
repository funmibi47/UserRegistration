package com.userreg.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userreg.web.Model.User;
import com.userreg.web.Service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class AppController {

	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		 
		 
		service.save(user);
		//return "home";
		return user;
	}
	 
	 
	
	 
}
