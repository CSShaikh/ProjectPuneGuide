package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "booking_seq", sequenceName = "booking_sequence", allocationSize = 1)

	private int id;
    private LocalDate bookingDate;
	
    private LocalDate travelDate;

    private String status; // e.g., CONFIRMED, CANCELED

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
   

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cab_id")
	private Cab cab;
	
//	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
//    private Payment payment;

	public Booking() {
		super();
	}

	public Booking(int id, LocalDate bookingDate, LocalDate travelDate, String status, LocalDateTime createdAt,
			User user, Hotel hotel, Cab cab) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.status = status;
		this.createdAt = createdAt;
		this.user = user;
		this.hotel = hotel;
		this.cab = cab;
		//this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

//	public Payment getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}

	
}