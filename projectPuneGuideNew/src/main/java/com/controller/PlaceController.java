package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exception.PlaceNotFoundException;
import com.model.Place;
import com.service.PlaceService;

@RestController
@RequestMapping("/place")
@CrossOrigin( origins="http://localhost:4200")

public class PlaceController {

	@Autowired
	PlaceService placeService;
	
	/*
	@PostMapping("/createPlace")
	public ResponseEntity<Place> createPlace(@RequestBody Place p){
		
		Place place=placeService.createPlace(p);
		
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Place Added").body(place);
	}*/
	
	 @PostMapping("/createPlace")
	    public ResponseEntity<Place> createPlace(@RequestParam("name") String name,
	                                             @RequestParam("description") String description,
	                                             @RequestParam("price") int price,
	                                             @RequestParam("location") String location,
	                                             @RequestParam("openDays") String openDays,
	                                             @RequestParam("openTime") String openTime,
	                                             @RequestParam("image") MultipartFile imageFile) throws IOException {
	        Place place = new Place();
	        place.setName(name);
	        place.setDescription(description);
	        place.setPrice(price);
	        place.setLocation(location);
	        place.setOpenDays(openDays);
	        place.setOpenTime(openTime);
	        place.setImage(imageFile.getBytes());
	        Place createdPlace = placeService.createPlace(place);
	        return ResponseEntity.ok(createdPlace);
	    }
	
	
	@GetMapping("/getPlaceById/{id}")
	public ResponseEntity<Place> getPlaceById(@PathVariable int id) {
        Optional<Place> place = placeService.getPlaceById(id);
        return place.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@DeleteMapping("/deletePlace/{id}")
	public ResponseEntity<Map<String, Object>> deletePlace(@PathVariable("id")int id)throws PlaceNotFoundException
	{
		Map<String,Object> response = placeService.deletePlace(id);
		
		return ResponseEntity.ok(response);
	}
	
	/*
	@PutMapping("/updatePlace")
	public ResponseEntity<Place> updateCab(@RequestBody Place place)
	{
		Place p=placeService.updatePlace(place);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Updated", "Place Updated").body(place);
	}*/
	
    @PutMapping("/updatePlace/{id}")
	public ResponseEntity<Place> updatePlace(@PathVariable int id,
			
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("location") String location,
            @RequestParam("openDays") String openDays,
            @RequestParam("openTime") String openTime,
            @RequestParam("image") MultipartFile imageFile) throws IOException {
		
		Optional<Place> existingPlaceOpt = placeService.getPlaceById(id);
		
		if (existingPlaceOpt.isPresent()) {
			Place place = existingPlaceOpt.get();
			place.setName(name);
			place.setDescription(description);
			place.setPrice(price);
			place.setLocation(location);
			place.setOpenDays(openDays);
			place.setOpenTime(openTime);
			place.setImage(imageFile.getBytes());
			Place updatedPlace = placeService.updatePlace(place);
			
			return ResponseEntity.ok(updatedPlace);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/getAllPlace")
	public List<Place> getAllPlace() {
		return placeService.getAllPlace();
	}
}
