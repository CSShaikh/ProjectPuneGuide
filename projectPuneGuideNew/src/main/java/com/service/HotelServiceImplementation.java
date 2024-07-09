package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HotelRepository;
import com.exception.HotelNotFoundException;
import com.model.Hotel;

@Service
public class HotelServiceImplementation implements HotelService{

	@Autowired
	HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	
	public Hotel getOneHotel(int id) {
		return hotelRepo.findById(id).orElse(null);
	}


	public Map<String,Object> deleteHotel(int id){
		
		Map<String ,Object > response=new HashMap<String,Object>();
		
		try {
			Hotel hotel= hotelRepo.findById(id).orElseThrow(()->new HotelNotFoundException(id+" "+"Hotel not exist"));
			
			hotelRepo.delete(hotel);
			response.put("deleted",Boolean.TRUE);
			
		}catch(HotelNotFoundException h)
		{
			response.put("not deleted", h.getMessage());
		}
		return response;
	}

	
	

	
	/*public Map<String, Object> updateHotel(Hotel hotel) throws HotelNotFoundException {

		Map<String,Object> response=new HashMap<String,Object>();
		
		try {
			Hotel h=hotelRepo.findById(hotel.getId()).orElseThrow(()-> new HotelNotFoundException("Hotel Not exit"));
			h.setHotelName(hotel.getHotelName());
			h.setStarRating(hotel.getStarRating());
			h.setMobileNo(hotel.getMobileNo());
		}catch(HotelNotFoundException u)
		{
			response.put("Not Updated", u.getMessage());
		}
		
		return null;

	}*/

	

	

	
		public Hotel updateHotel(Hotel hotel) {
		
		Hotel h=hotelRepo.findById(hotel.getId()).orElse(null);
		
		h.setId(hotel.getId());
		h.setHotelName(hotel.getHotelName());
		h.setStarRating(hotel.getStarRating());
		h.setMobileNo(hotel.getMobileNo());
		
		return hotelRepo.save(h);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	
}
