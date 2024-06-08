package com.jsp.TaskManagement.ServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.TaskManagement.Entity.Users;
import com.jsp.TaskManagement.Repository.UserRepository;
import com.jsp.TaskManagement.Service.UsersService;
import com.jsp.TaskManagement.payload.UserDto;

@Service
public class UsersServiceImplementation implements UsersService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDto createUser(UserDto userDto) {
		//it is not an entity of Users
		Users user=userDtoToEntity(userDto);
		Users savedUser=userRepository.save(user);
		return entityToUserDto(savedUser);
		
	}
	private Users userDtoToEntity(UserDto userDto) {
		Users users=new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPwd(userDto.getPassword());
		
		return users;
	}
	private UserDto entityToUserDto(Users savedUser) {
		UserDto userDto=new UserDto();	
		userDto.setId(savedUser.getId());
		userDto.setEmail(savedUser.getEmail());
		userDto.setPassword(savedUser.getPwd());
		userDto.setName(savedUser.getName());
		return userDto;
		}
	

}
