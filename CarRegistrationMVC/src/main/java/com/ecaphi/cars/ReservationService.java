package com.ecaphi.cars;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecaphi.cars.model.Car;
import com.ecaphi.cars.repo.ReservationResository;

@Service
public class ReservationService {

	private ReservationResository reservationResository;
	
	@Autowired
	public ReservationService(ReservationResository reservationResository)
	{
		super();
		this.reservationResository = reservationResository;
	}
	
	public List<Car> getAllCars() 
	{
		List<Car> cars = new ArrayList<>();
		this.reservationResository.findAll().forEach(cars::add);
		
		return cars;
	}
	
	public void addCar(Car car)
	{
		this.reservationResository.save(car);
	}	

	public void deleteCar(int carId)
	{
		this.reservationResository.deleteById(carId);
	}
	
	public void updateCar(Car car)
	{
		this.reservationResository.save(car);
	}
	
	public Car getCarById(int carId)
	{
		return this.reservationResository.findById(carId).get();
	}		
}
