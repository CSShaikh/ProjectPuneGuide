package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.exception.PlaceNotFoundException;
import com.model.Place;

public interface PlaceService {

	public Place createPlace(Place place);
	
	//public Place getOnePlace(int id);
	
	public Map<String,Object> deletePlace(int id)throws PlaceNotFoundException;
		
	public Place updatePlace(Place place);

	public List<Place> getAllPlace();

	public Optional<Place> getPlaceById(int id);


}
