package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.User;
import com.project.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
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

	@Override
	public boolean isEmailExist(String email) {
		User user = userRep.findByEmail(email);
		 
		 if(user != null) {
			 throw new RuntimeException("이미 존재하는 이메일입니다.");
		 }else {
			return false; 
		 }
	}

}
