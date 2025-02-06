package com.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.User;
import com.project.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Tag(name = "User API", description = "사용자 관리 API")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	@Operation(summary = "사용자 생성", description = "새로운 사용자를 생성합니다.")
	public Object signUp(@RequestBody User user, BindingResult bindingResult) {
		
		//이메일 중복 검사
		User dbUser = null;
		if (!userService.isEmailExist(user.getEmail())) {
			dbUser = userService.signUp(user);
		}
		
		//response할 객체 생성
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", dbUser);
		
		return map;
	}
	
}
