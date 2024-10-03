package com.jsp.userspringm17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userspringm17.dao.UserDao;
import com.jsp.userspringm17.dto.User;
import com.jsp.userspringm17.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User data saved successfullys");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUser(int userId) {
		User dbUser=dao.findUser(userId);
		
		if(dbUser!=null) {
//			user is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User data fetched successfullys");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);	
		}else {
//			user is not present
			
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User data not found");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);	

		}
		
		
		
		
		
		
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User user) {
		User dbUser=dao.updateUser(user,userId);
		if(dbUser!=null) {
//			data updated successfully
			
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User data updated successfullys");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);	
			
			
			
		}else {
//			id is not present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User data not found");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);	
		}
	
	
	
	
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int userId) {
		User dbUser=dao.deleteUser(userId);
		if(dbUser!=null) {
//			data updated successfully
			
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User data deleted successfullys");
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FORBIDDEN);	
			
			
			
		}else {
//			id is not present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User data not found");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);	
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
