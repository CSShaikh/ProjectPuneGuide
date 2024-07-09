package com.service;

import java.util.List;
import java.util.Map;

import com.exception.HotelNotFoundException;
import com.model.Hotel;

public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	
	public Hotel getOneHotel(int id);
	
	public Map<String,Object> deleteHotel(int id)throws HotelNotFoundException;
		

	public Hotel updateHotel(Hotel hotel);
	
	public List<Hotel> getAllHotel();


}
