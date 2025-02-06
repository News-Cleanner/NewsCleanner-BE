package com.project.service;

import com.project.domain.User;

public interface UserService {
	User signUp(User user);
	User findByEmail(String email);
	
}
