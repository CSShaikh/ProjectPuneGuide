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

import com.exception.HotelNotFoundException;
import com.model.Hotel;
import com.service.HotelService;

@RestController
@RequestMapping("/hotel")
@CrossOrigin( origins="http://localhost:4200")

public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel h){
		Hotel hotel=hotelService.createHotel(h);
		return ResponseEntity.status(HttpStatus.CREATED).header("Created", "Hotel Created").body(hotel);
	}
	
	@GetMapping("/getOneHotel/{id}")
	public ResponseEntity<Hotel> getOneHotel(@PathVariable("id")int id){
		
		Hotel hotel=hotelService.getOneHotel(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get","Get Hotel").body(hotel);	
	}
	
	@DeleteMapping("/deleteHotel/{id}")
	public ResponseEntity<Map<String, Object>> deleteHotel(@PathVariable("id")int id)throws HotelNotFoundException
	{
		Map<String,Object> response = hotelService.deleteHotel(id);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updateHotel")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel)
	{
		Hotel h=hotelService.updateHotel(hotel);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Updated", "Hotel Updated").body(hotel);
	}
	
	@GetMapping("/getAllHotel")
	public List<Hotel> getAllHotel() {
		return hotelService.getAllHotel();
	}
}
