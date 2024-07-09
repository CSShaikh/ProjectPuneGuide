package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CabRepository;
import com.exception.CabNotFoundException;
import com.model.Cab;

@Service
public class CabServiceImplamenetation implements CabService {
	
	@Autowired
	CabRepository cabRepo;

	
	public Cab createCab(Cab cab) {
		
		return cabRepo.save(cab);
	}
	

	public Optional<Cab> getCabById(int id) {
        return cabRepo.findById(id);
    }


	public Map<String,Object> deleteCab(int id){
		
		Map<String ,Object > response=new HashMap<String,Object>();
		
		try {
			Cab cab= cabRepo.findById(id).orElseThrow(()->new CabNotFoundException(id+" "+"Cab not exist"));
			
			cabRepo.delete(cab);
			response.put("deleted",Boolean.TRUE);
			
		}catch(CabNotFoundException u)
		{
			response.put("not deleted", u.getMessage());
		}
		return response;
	}
	
	public Cab updateCab(Cab cab) {
		
		Cab c=cabRepo.findById(cab.getId()).orElse(null);
		
		c.setId(cab.getId());
		c.setCarName(cab.getCarName());
		c.setCabType(cab.getCabType());
		c.setCabNo(cab.getCabNo());
		c.setPlace(cab.getPlace());
		
		return cabRepo.save(c);
    }


	public List<Cab> getAllCab() {
		return cabRepo.findAll();
	}


	

	
	

	
}
