package com.jsp.userspringm17.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userspringm17.dto.User;
import com.jsp.userspringm17.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
//		how to save
		return repo.save(user);

	}

	public User findUser(int userId) {
		Optional<User> optional = repo.findById(userId);
		if (optional.isPresent()) {
//			something is present inside that optional
//			user data is present inside the optional
			User user = optional.get();
			return user;
		} else {
//			user id is not present
			return null;
		}
	}

	public User updateUser(User user, int userId) {
		Optional<User> optional = repo.findById(userId);

		if (optional.isPresent()) {

			user.setId(userId);
			return repo.save(user);

		} else {
			return null;
		}

	}

	public User deleteUser(int userId) {
		Optional<User> optional = repo.findById(userId);

		if (optional.isPresent()) {
			repo.deleteById(userId);
			return optional.get();

		} else {
			return null;
		}

	}

}
