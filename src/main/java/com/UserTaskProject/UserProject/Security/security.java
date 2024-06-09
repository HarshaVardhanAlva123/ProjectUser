package com.UserTaskProject.UserProject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class security {
	
//used to authenticate all the incoming request
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		
		//.antMatchers(HttpMethod.POST,"api/gettask/**").permitAll.

		http
		.csrf().disable().authorizeRequests().
		anyRequest().authenticated();
		
		return http.build();
	}
	//used to validate userr deatils
	
	
	@Bean
	public AuthenticationManager authenticationmanager(AuthenticationConfiguration authenticationconfiguration )throws Exception
	{
		
		return authenticationconfiguration.getAuthenticationManager();
	}
	

}
