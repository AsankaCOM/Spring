package com.ecaphi.cars;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ecaphi.cars.dao.CarDao;
import com.ecaphi.cars.model.Car;
import com.ecaphi.cars.repo.ReservationResository;

@Service
public class ReservationService {

	//private CarDao dao;
	private ReservationResository reservationResository;
	
	@Autowired
	public ReservationService(ReservationResository reservationResository)
	{
		super();
		this.reservationResository = reservationResository;
	}
	
	public List<Car> getAllCars() 
	{
		//return this.dao.getAllCars();
		
		List<Car> cars = new ArrayList<>();
		this.reservationResository.findAll().forEach(cars::add);
		
		return cars;
	}
	
	
	public void addCar(Car car)
	{
		//this.dao.addCar(car);
		this.reservationResository.save(car);
	}
	

	public void deleteCar(int carId)
	{
		//this.dao.deleteCar(carId);
		this.reservationResository.deleteById(carId);
	}
	
	public void updateCar(Car car)
	{
		//this.dao.updateCar(car);
		this.reservationResository.save(car);
	}
	
	public Car getCarById(int carId)
	{
		//return this.dao.getCarById(carId);
		//return this.reservationResository.findById(carId).get();
		return this.reservationResository.findById(carId).get();
		
	}	
	
}
