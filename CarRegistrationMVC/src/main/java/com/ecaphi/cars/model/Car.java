package com.ecaphi.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car {

	@Id
	@Column(name="CAR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="REG_NO")
	private String registrationNumber;
	
	public int getCarId() {
		return carId;
	}
	
	public void setCarId(int carId){
		this.carId = carId;
	}
	
	public void setCarId(String carId){
		this.carId = Integer.parseInt(carId);
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber){
		this.registrationNumber = registrationNumber;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
	
	public String getModel(){
		return model;
	}
	
	public void setModel (String model){
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", manufacturer=" + manufacturer + ", model=" + model + "]";
	}
}
