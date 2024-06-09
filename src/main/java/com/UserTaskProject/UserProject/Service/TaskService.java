package com.UserTaskProject.UserProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.UserTaskProject.UserProject.Entity.task;
import com.UserTaskProject.UserProject.Entity.user;
import com.UserTaskProject.UserProject.Exception.Tasknotfound;
import com.UserTaskProject.UserProject.Exception.Usernotfoundexception;
import com.UserTaskProject.UserProject.Exception.ApiNotfound;
import com.UserTaskProject.UserProject.Repository.TskRepository;
import com.UserTaskProject.UserProject.Repository.UserRepository;


@Service
public class TaskService {

	@Autowired
	private TskRepository taskrep;
	@Autowired
	private UserRepository rep;

	public void savetask(Integer userid, task ts) {
		// TODO Auto-generated method stub
	user us=rep.findById(userid).orElseThrow(() -> new Usernotfoundexception(String.format("User %d not found", userid)));								
	ts.setUsers(us);
	taskrep.save(ts);	
	}

	public List<task> getalltasks(Integer userid) {
		// TODO Auto-generated method stub
		user us=rep.findById(userid).orElseThrow(() -> new Usernotfoundexception(String.format("User %d not found", userid)));			
		
		
		return taskrep.findAllByUsers_Id(userid);
		
		
		}

	public task  getindvid(Integer user_id, Integer id) {
		// TODO Auto-generated method stub
		user us=rep.findById(user_id).orElseThrow(() -> new Usernotfoundexception(String.format("User %d not found", user_id)));			
		
		task ts=taskrep.findById(id).orElseThrow(() -> new Tasknotfound(String.format("Task%d not found", id)));
	if(us.getId() != ts.getId())
	{
		throw new  ApiNotfound(String.format("User %d and Task %d goes not maatch ", user_id,id));
		
	}
    return ts;  
		
	}
	

	
	
}
