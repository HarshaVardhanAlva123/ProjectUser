package com.UserTaskProject.UserProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String taskname;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private user users;

	
	public task(Integer id, String taskname, user users) {
		this.id = id;
		this.taskname = taskname;
		this.users = users;
	}


	public task() {
	}


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


	public user getUsers() {
		return users;
	}


	public void setUsers(user users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "task [id=" + id + ", taskname=" + taskname + ", users=" + users + "]";
	}
	
	

}
