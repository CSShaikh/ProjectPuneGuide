package com.service;

import java.util.List;
import java.util.Map;

import com.exception.BookingNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Booking;

public interface BookingService {
	

	public Booking createBooking(Booking booking) throws UserNotFoundException;

	public Booking getOneBooking(int id);
	
	public Map<String,Object> deleteBooking(int id)throws BookingNotFoundException;
		
	public Booking updateBooking(Booking booking);
	

	public List<Booking> getAllBooking();


}
