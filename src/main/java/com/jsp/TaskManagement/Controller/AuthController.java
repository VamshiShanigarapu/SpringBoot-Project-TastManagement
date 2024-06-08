package com.jsp.TaskManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.TaskManagement.Entity.Users;
import com.jsp.TaskManagement.Repository.UserRepository;
import com.jsp.TaskManagement.Service.UsersService;
import com.jsp.TaskManagement.payload.UserDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	UsersService userService;
	//POST to store the data in to DB
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUer(@RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(userService.createUser(userDto),HttpStatus.CREATED) ;
	}

}
