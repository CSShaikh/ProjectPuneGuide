package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {

	
}