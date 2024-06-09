package com.UserTaskProject.UserProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserTaskProject.UserProject.Entity.task;
import com.UserTaskProject.UserProject.Service.TaskService;

@RestController
@RequestMapping("api")
public class TaskCOntroller {

	@Autowired
	private TaskService service;

	@PostMapping("task/{userid}/savetask")
	public void savetask(@PathVariable Integer userid, @RequestBody task ts) {
		service.savetask(userid, ts);
	}

	@PreAuthorize(value = "ROLE_ADMIN")
	@GetMapping("gettask/{user_id}")
	public List<task> getalltasks(@PathVariable Integer user_id) {
		return service.getalltasks(user_id);
	}

	@GetMapping("indvtask/{user_id}/{id}")
	public task getindvid(@PathVariable Integer user_id, @PathVariable Integer id) {
		return service.getindvid(user_id, id);
	}
}
