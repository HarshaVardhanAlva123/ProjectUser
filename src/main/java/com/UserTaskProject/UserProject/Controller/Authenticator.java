package com.UserTaskProject.UserProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserTaskProject.UserProject.Entity.user;
import com.UserTaskProject.UserProject.Exception.Usernotfoundexception;
import com.UserTaskProject.UserProject.Payload.LoginDto;
import com.UserTaskProject.UserProject.Service.UserService;

@RestController
@RequestMapping("/api/auth")
public class Authenticator {
	
	@Autowired
	private UserService serviceuser;
	
	@Autowired
	private AuthenticationManager  authenticationmanager;
	
	@PostMapping("register")
	public void createuser(@RequestBody user us)
	{
		serviceuser.createuser(us);
	}
	
	@PostMapping("registerall")
	public List<user> saveallusers(@RequestBody List<user> us)
	{
		return serviceuser.saveallusers(us);
	}
	@PostMapping("Login")
	public String loginauthentication(@RequestBody LoginDto login)
	{
		Authentication authentication=authenticationmanager.authenticate(
			new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));       
		SecurityContextHolder.getContext().setAuthentication(authentication);	
		return "Sucess";	
	}
	
	
	public UserDetails LoadUserByUsername(String email)  
	{
		return serviceuser.LoadUserByUsername(email);
	}
	

}
