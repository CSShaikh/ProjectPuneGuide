package com.service;

import java.util.List;
import java.util.Map;

import com.exception.UserNotFoundException;
import com.model.User;

public interface UserService {

	public User createUser(User u);

	public User getOneUser(int id);
	
	//public Tourist deleteTourist(int id);
	
	public Map<String,Object> deleteUser(int id)throws UserNotFoundException;
	
	public User updateUser(User uer);
	
	public List<User> getAllUser();

	//public Map<String,Object> updateUser(int id)throws UserNotFoundException;

}
