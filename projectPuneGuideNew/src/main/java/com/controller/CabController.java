package com.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.exception.CabNotFoundException;
import com.model.Cab;
import com.model.Hotel;
import com.service.CabService;

@RestController
@RequestMapping("/cab")
@CrossOrigin( origins="http://localhost:4200")

public class CabController {

	@Autowired
	CabService cabService;
	
	@PostMapping("/createCab")
	public ResponseEntity<Cab> createCab(@RequestBody Cab c){
		
		Cab cab=cabService.createCab(c);
		
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Cab Added").body(cab);
	}
	
	@GetMapping("/getOneCab/{id}")
	 public ResponseEntity<Cab> getCabById(@PathVariable int id) {
        Optional<Cab> cab = cabService.getCabById(id);
        return cab.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@DeleteMapping("/deleteCab/{id}")
	public ResponseEntity<Map<String, Object>> deleteCab(@PathVariable("id")int id)throws CabNotFoundException
	{
		Map<String,Object> response = cabService.deleteCab(id);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updateCab")
	public ResponseEntity<Cab> updateCab(@RequestBody Cab cab)
	{
		Cab c=cabService.updateCab(cab);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Updated", "Cab Updated").body(cab);
	}
	
	
	@GetMapping("/getAllCab")
	public List<Cab> getAllCab() {
		return cabService.getAllCab();
	}
}
