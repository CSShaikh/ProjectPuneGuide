package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BookingRepository;
import com.dao.CabRepository;
import com.dao.HotelRepository;
import com.dao.UserRepository;
import com.exception.BookingNotFoundException;

import com.model.Booking;
import com.model.Cab;
import com.model.Hotel;
import com.model.User;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImplementation implements BookingService {

	@Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private CabRepository cabRepo;

    @Override
    @Transactional
    public Booking createBooking(Booking booking) throws RuntimeException {
        // Retrieve and set the User entity
        User user = userRepo.findById(booking.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);

        // Retrieve and set the Hotel entity
        Hotel hotel = hotelRepo.findById(booking.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        booking.setHotel(hotel);

        // Retrieve and set the Cab entity
        Cab cab = cabRepo.findById(booking.getCab().getId())
                .orElseThrow(() -> new RuntimeException("Cab not found"));
        booking.setCab(cab);

        return bookingRepo.save(booking);
    }

	
	public Booking getOneBooking(int id) {
		return bookingRepo.findById(id).orElse(null);
	}


	public Map<String,Object> deleteBooking(int id){
		
		Map<String ,Object > response=new HashMap<String,Object>();
		
		try {
			Booking booking= bookingRepo.findById(id).orElseThrow(()->new BookingNotFoundException(id+" "+"Booking not exist"));
			
			bookingRepo.delete(booking);
			response.put("deleted",Boolean.TRUE);
			
		}catch(BookingNotFoundException b)
		{
			response.put("not deleted", b.getMessage());
		}
		return response;
	}
	
	public Booking updateBooking(Booking booking) {
		Booking b= bookingRepo.findById(booking.getId()).orElse(null);
		
		b.setId(booking.getId());
		b.setBookingDate(booking.getBookingDate());
		b.setUser(booking.getUser());
		b.setHotel(booking.getHotel());
		b.setCab(booking.getCab());

		return bookingRepo.save(b);
	}


	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookingRepo.findAll();
	}


}
