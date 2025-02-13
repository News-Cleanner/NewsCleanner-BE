package com.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;

import com.project.domain.User;
import com.project.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRep;
	
	@Test
	void testSave() {
		User user=new User("awa@naver.com", "1234");
		User savedUser=userRep.save(user);
		
		User foundUser=userRep.findByEmail("awa@naver.com");
		
		assertNotNull(savedUser);
	}
	

}
