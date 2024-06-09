package com.UserTaskProject.UserProject.Repository;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserTaskProject.UserProject.Entity.task;
import com.UserTaskProject.UserProject.Entity.user;

@Repository
public interface UserRepository  extends JpaRepository<user,Integer>{

	Optional<user> findByEmail(String email);

	

}
