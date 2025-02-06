package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.domain.User;
import com.project.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRep;

	@Override
	public User signUp(User user) {
		
		user = userRep.save(user);
		return user;
	}

}
