package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {

}
