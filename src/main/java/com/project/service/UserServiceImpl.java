package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.domain.User;
import com.project.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRep;

	@Override
	public User signUp(User user) {
		
		User savedUser = userRep.save(user);
		return savedUser;
	}

	@Override
	public User findByEmail(String email) {
		User user = userRep.findByEmail(email);
		return user;
	}

}
