package com.analytics.service;

import org.springframework.http.ResponseEntity;

import com.analytics.dto.UserDetailsDto;
import com.analytics.dto.UserLoginDto;

public interface UserService {

	public ResponseEntity<String> save(UserDetailsDto uDetailsDto);

	public ResponseEntity<String> login(UserLoginDto userLoginDto);

}
