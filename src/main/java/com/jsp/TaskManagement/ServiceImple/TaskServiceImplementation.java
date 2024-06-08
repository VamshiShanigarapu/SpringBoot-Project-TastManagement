package com.jsp.TaskManagement.ServiceImple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.TaskManagement.Entity.Task;
import com.jsp.TaskManagement.Entity.Users;
import com.jsp.TaskManagement.Exception.APIException;
import com.jsp.TaskManagement.Exception.TaskNotFound;
import com.jsp.TaskManagement.Exception.UserNotFound;
import com.jsp.TaskManagement.Repository.TaskRepository;
import com.jsp.TaskManagement.Repository.UserRepository;
import com.jsp.TaskManagement.Service.TaskService;
import com.jsp.TaskManagement.payload.TaskDto;

@Service
public class TaskServiceImplementation implements TaskService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TaskRepository taskRepository;
	@Override
	public TaskDto saveTask(long userid, TaskDto taskDto) {
		 Users user=userRepository.findById(userid).orElseThrow( ()-> new UserNotFound(String.format("user id %d not found", userid))
				 );
		 Task task=modelMapper.map(taskDto, Task.class);
		 task.setUser(user);
		 
		 Task saveTask=taskRepository.save(task);
		 
		return modelMapper.map(saveTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAlltasks(long userid) {
		userRepository.findById(userid).orElseThrow( 
				()-> new UserNotFound(String.format("user id %d not found", userid))
				 );
		List<Task> tasks =taskRepository.findAllByUsersId(userid);
		return tasks.stream().map(
				task->modelMapper.map(task ,TaskDto.class)).collect(Collectors.toList());
	}

	@Override
	public TaskDto getTask(long userid, long taskid) {
		Users users=userRepository.findById(userid).orElseThrow( 
				()-> new UserNotFound(String.format("user id %d not found", userid))
				 );
		Task task=taskRepository.findById(taskid).orElseThrow( 
				()->new TaskNotFound(String.format("task id %d not found", taskid))
				);
		if(users.getId()!=task.getUser().getId()) {
			throw new APIException(String.format("Task id is not belongs to User Id %d", taskid,userid));
			}
		return modelMapper.map(task, TaskDto.class);
	}

}
