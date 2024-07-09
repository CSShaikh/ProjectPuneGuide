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

import com.exception.BookingNotFoundException;
import com.model.Booking;
import com.model.User;
import com.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin( origins="http://localhost:4200")

public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/createBooking")
	 public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) throws Exception {
        Booking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }
	
	@GetMapping("/getOneBooking/{id}")
	public ResponseEntity<Booking> getOneBooking(@PathVariable("id")int id){
		
		Booking booking=bookingService.getOneBooking(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get","Get Booking").body(booking);	
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<Map<String, Object>> deleteBooking(@PathVariable("id")int id)throws BookingNotFoundException
	{
		Map<String,Object> response = bookingService.deleteBooking(id);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updateBooking")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
		Booking b=bookingService.updateBooking(booking);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("updated","Cab updated").body(booking);	
	}
	
	@GetMapping("/getAllBooking")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}
}
