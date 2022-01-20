package com.userreg.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.userreg.web.Dao.UserRepository;
import com.userreg.web.Model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void save(User user) {
		repo.save(user);
	}
	
	public List<User> listAll(){
		return repo.findAll();
		}
}
