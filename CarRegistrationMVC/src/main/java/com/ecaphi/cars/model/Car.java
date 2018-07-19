package com.ecaphi.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="cars")
public class Car {

	@Id
	@Column(name="CAR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;
	
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="REG_NO")
	private String registrationNumber;
	
	public Integer getCarId() {
		return carId;
	}
	
	public void setCarId(Integer carId){
		this.carId = carId;
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
	public boolean equals(Object o) {
		if (this.equals(o)) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(registrationNumber, car.registrationNumber);
	}

	@Override
	public int hashCode() {

		return Objects.hash(registrationNumber);
	}

	@Override
	public String toString() {
		return "Car{" +
				"carId=" + carId +
				", manufacturer='" + manufacturer + '\'' +
				", model='" + model + '\'' +
				", city='" + city + '\'' +
				", registrationNumber='" + registrationNumber + '\'' +
				'}';
	}

}
