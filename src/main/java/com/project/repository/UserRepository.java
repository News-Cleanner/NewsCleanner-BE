package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String Email);
	
	@Query(value="select u from User u where u.email = ?1")
	User signIn(String email);
}
