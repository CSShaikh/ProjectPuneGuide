package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.exception.UserNotFoundException;
import com.model.User;

@Service
public class UserServiceImplementation implements UserService {
	

	@Autowired
	UserRepository userRepo;
	public User createUser(User u) {
		return userRepo.save(u);
	}

	public User getOneUser(int id) {
		return userRepo.findById(id).orElse(null);
	}


	/*
	public Tourist deleteUser(int id) {
		userRepo.deleteById(id);
		return null;
	}*/

	public Map<String,Object> deleteUser(int id){
		
		Map<String ,Object > response=new HashMap<String,Object>();
		
		try {
			User user= userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User not exist"+id));
			
			userRepo.delete(user);
			response.put("delete",Boolean.TRUE);
			
		}catch(UserNotFoundException u)
		{
			response.put("not deleted", u.getMessage());
		}
		
		return response;
	
	}

	/*
	public Map<String, Object> updateUser(int id){
		
		Map<String,Object> response=new HashMap<String,Object>();
		
		
		try {
			User u=userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User Not exit"+id));
		}catch(UserNotFoundException u)
		{
			response.put("Not Updated", u.getMessage());
		}
		
		return null;
	}*/

	
	public User updateUser(User user) {
		User u= userRepo.findById(user.getId()).orElse(null);
		
		u.setId(user.getId());
		u.setUserName(user.getUserName());
		u.setPassword(user.getPassword());
		u.setMobileNo(user.getMobileNo());
		u.setEmail(user.getEmail());
		//u.setBookings(user.getBookings());
		u.setCab(user.getCab());
		u.setCreatedAt(user.getCreatedAt());
		u.setPlaces(user.getPlaces());
		u.setAdmin(user.getAdmin());
		
		return userRepo.save(u);
	}
	

	

	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	

	

	
}
