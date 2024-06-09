package com.UserTaskProject.UserProject.Payload;

import com.UserTaskProject.UserProject.Entity.user;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TaskDto {
	private Integer id;
	private String taskname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	
	
}
