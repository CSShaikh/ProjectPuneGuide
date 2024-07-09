package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.UserNotFoundException;
import com.model.Place;
import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin( origins="http://localhost:4200")

public class UserController {

	@Autowired
	UserService userService;
	
	
			//Adding Tourist without response
	
	/*@PostMapping("/add")
	public Tourist saveTourist(@RequestBody Tourist t) {
		return touristService.saveTourist(t);
	}*/
	
			
			//Adding Tourist With Response Created
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User u){
		
		User user=userService.createUser(u);
		
		return ResponseEntity.status(HttpStatus.CREATED).header("add","User Added").body(user);
	}
	
	
			// Get/Read Tourist  without response
	
	@GetMapping("/getOneuser/{id}")
	public User getOneUser(@PathVariable("id")int id) {
		return userService.getOneUser(id);
	}
	
	/*		// Get/Read Tourist with response
	@GetMapping("/getOneTourist/{tourist_id}")
	public ResponseEntity<Tourist> getOneTourist(@PathVariable("tourist_id")int tourist_id){
		
		Tourist tourist=touristService.getOneTourist(tourist_id);
		return ResponseEntity.status(HttpStatus.OK).header("Get","Get Tourist").body(tourist);	
	}*/
	
	/*
			//Delete Tourist 
	@DeleteMapping("/deleteTourist/{tourist_id}")
	public void deleteTourist(@PathVariable("tourist_id")int tourist_id) {
		touristService.deleteTourist(id);
	}*/
	
			//Delete Tourist With Response
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable("id")int id)throws UserNotFoundException
	{
		Map<String,Object> response = userService.deleteUser(id);
		
		return ResponseEntity.ok(response);
	}
	
			//Update Tourist  with Response
	/*@PutMapping("/updateTourist")
	public ResponseEntity<Tourist> updateTourist(@RequestBody Tourist tourist){
		Tourist t=touristService.updateTourist(tourist);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("updated","Tourist updated").body(tourist);
	}*/
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		User u=userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Updated", "User Updated").body(user);
	}
	
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
}
