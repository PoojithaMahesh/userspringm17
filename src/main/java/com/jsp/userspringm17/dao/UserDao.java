package com.jsp.userspringm17.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userspringm17.dto.User;
import com.jsp.userspringm17.repo.UserRepo;
@Repository
public class UserDao {
	
	@Autowired
	private UserRepo repo;
	
	public void saveUser(User user) {
//		how to save
		repo.save(user);
		
	}

}
