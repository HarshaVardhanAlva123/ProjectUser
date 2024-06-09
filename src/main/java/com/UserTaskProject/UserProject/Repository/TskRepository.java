package com.UserTaskProject.UserProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserTaskProject.UserProject.Entity.task;

@Repository
public interface TskRepository extends JpaRepository<task,Integer> {

	List<task> findAllByUsers_Id(Integer user_id);

	



}
