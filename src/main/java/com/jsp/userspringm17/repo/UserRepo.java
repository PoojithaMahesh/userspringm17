package com.jsp.userspringm17.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.userspringm17.dto.User;

public interface UserRepo extends JpaRepository<User,Integer >{

}
