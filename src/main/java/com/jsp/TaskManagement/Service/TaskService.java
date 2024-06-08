package com.jsp.TaskManagement.Service;

import java.util.List;

import com.jsp.TaskManagement.payload.TaskDto;

public interface TaskService {

	public TaskDto saveTask(long userid,TaskDto taskDto);
	
	public List<TaskDto>  getAlltasks(long userid);
	
	public TaskDto getTask(long userid,long taskid);
	}
