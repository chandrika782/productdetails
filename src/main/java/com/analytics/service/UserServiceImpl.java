package com.analytics.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.analytics.dto.UserDetailsDto;
import com.analytics.dto.UserLoginDto;
import com.analytics.model.UserDetails;
import com.analytics.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override

	public ResponseEntity<String> save(UserDetailsDto userDetailsDto) {

		UserDetails userDetails = new UserDetails();
		BeanUtils.copyProperties(userDetailsDto, userDetails);

		userRepository.save(userDetails);
		return new ResponseEntity<String>("User details saved suucessfully!!!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> login(UserLoginDto userLoginDto) {
		userRepository.findByUserNameAndPassword(userLoginDto.getUserName(), userLoginDto.getPassword());
		return new ResponseEntity<String>("login successfully...", HttpStatus.OK);
	}

}
