package com.UserTaskProject.UserProject.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.UserTaskProject.UserProject.Entity.user;
import com.UserTaskProject.UserProject.Exception.Usernotfoundexception;
import com.UserTaskProject.UserProject.Repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository rep;
	public void createuser(user us) {
		// TODO Auto-generated method stub
		rep.save(us);
	}
	public List<user> saveallusers(List<user> us) {
		// TODO Auto-generated method stub
		rep.saveAll(us);
		return null;
	}
	public UserDetails LoadUserByUsername(String email)  {
		// TODO Auto-generated method stub
	user USER=rep.findByEmail(email).orElseThrow(
			() -> new Usernotfoundexception(String.format("User Email :%s is not found", email)));
	Set<String> roles=new HashSet<String>();
	
	roles.add("ROLE_ADMIN");
	
	
	return new User(USER.getEmail(), USER.getPassword(), userauthority(roles));
	
	
	} 
	private Collection<? extends GrantedAuthority> userauthority(Set<String> roles)
	{
		return roles.stream().map(
				
				role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());				
	}

}
