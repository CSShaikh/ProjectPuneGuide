package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlaceRepository;
import com.exception.PlaceNotFoundException;
import com.model.Place;

@Service
public class PlaceServiceImplementation implements PlaceService{

	@Autowired
	PlaceRepository placeRepo;
	
	public Place createPlace(Place place) {
		return placeRepo.save(place);
	}

	 public Optional<Place> getPlaceById(int id) {
	        return placeRepo.findById(id);
	    }


	public Map<String,Object> deletePlace(int id){
		
		Map<String ,Object > response=new HashMap<String,Object>();
		
		try {
			Place place= placeRepo.findById(id).orElseThrow(()->new PlaceNotFoundException(id+" "+"Place not exist"));
			
			placeRepo.delete(place);
			response.put("deleted",Boolean.TRUE);
			
		}catch(PlaceNotFoundException u)
		{
			response.put("not deleted", u.getMessage());
		}
		return response;
	}
	
	/*
	public Place updatePlace(Place place) {
		Place p= placeRepo.findById(place.getId()).orElse(null);
		
		p.setId(place.getId());
		p.setName(place.getName());
		p.setDescription(place.getDescription());
		p.setPrice(place.getPrice());
		p.setLocation(place.getLocation());

		return placeRepo.save(p);
	}*/

	public Place updatePlace(Place place) {
        if (placeRepo.existsById(place.getId())) {
            return placeRepo.save(place);
        } else {
            throw new RuntimeException("Place not found with id: " + place.getId());
        }
    }
	
	@Override
	public List<Place> getAllPlace() {
		return placeRepo.findAll();
	}
}
