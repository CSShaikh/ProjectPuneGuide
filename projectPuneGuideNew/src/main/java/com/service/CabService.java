package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.exception.CabNotFoundException;
import com.model.Cab;


public interface CabService {

	public Cab createCab(Cab cab);
		
	public Map<String,Object> deleteCab(int id)throws CabNotFoundException;

	public Optional<Cab> getCabById(int id);
	
    public Cab updateCab(Cab cab);	

	
	public List<Cab> getAllCab();

}
