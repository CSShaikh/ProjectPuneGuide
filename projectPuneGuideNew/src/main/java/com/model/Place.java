package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Place {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
    @Column(nullable = false)
	private String name;
    
    @Column(columnDefinition = "TEXT")
	private String description;
    
    @Column(nullable = false)
	private int price;
    
    @Column(nullable = false)
	private String location;
    
    @Column(nullable = false)
    private String openDays; // Example: "Monday-Sunday"
    
    @Column(nullable = false)
    private String openTime; // Example: "09:00 AM - 05:00 PM"

    
    @Lob
    @Column(name = "image", columnDefinition="BLOB")
    private byte[] image;
    
//    @OneToOne(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Cab cab;

	
	public Place() {
		super();
	}

	public Place(int id, String name, String description, int price, String location, String openDays, String openTime,
		byte[] image) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
	this.location = location;
	this.openDays = openDays;
	this.openTime = openTime;
	this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOpenDays() {
		return openDays;
	}

	public void setOpenDays(String openDays) {
		this.openDays = openDays;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
	
	
	

	
	
}
