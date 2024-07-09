package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cab {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(nullable = false)
	private String carName;
	
    @Column(nullable = false)
	private String cabType;
    
    @Column(nullable = false)
	private String cabNo;
	
//	@OneToOne(mappedBy = "cab", fetch = FetchType.EAGER)
//	private Booking booking;
	
	@OneToOne
    //@JoinColumn(name = "place_id", unique = true)
    private Place place;  // One-to-one relationship with Place
	
	

	public Cab() {
		super();
	}

	public Cab(int id, String carName, String cabType, String cabNo, Place place) {
		super();
		this.id = id;
		this.carName = carName;
		this.cabType = cabType;
		this.cabNo = cabNo;
		//this.booking = booking;
		this.place = place;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public String getCabNo() {
		return cabNo;
	}

	public void setCabNo(String cabNo) {
		this.cabNo = cabNo;
	}

//	public Booking getBooking() {
//		return booking;
//	}
//
//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	
}