package com.analytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.dto.UserDetailsDto;
import com.analytics.dto.UserLoginDto;
import com.analytics.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<String> createUser(@RequestBody UserDetailsDto userDetailsDto){
		return userService.save(userDetailsDto);
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserLoginDto userLoginDto){
		return userService.login(userLoginDto);
}
}
