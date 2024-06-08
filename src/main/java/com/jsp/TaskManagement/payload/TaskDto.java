package com.jsp.TaskManagement.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

	private long id;
	private String task;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
}
