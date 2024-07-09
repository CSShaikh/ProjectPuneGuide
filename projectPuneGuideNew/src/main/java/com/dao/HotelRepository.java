package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
