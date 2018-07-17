package com.ecaphi.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecaphi.cars.model.Car;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private ReservationService reservationService;
	
	@Autowired
	public ApiController(ReservationService reservationService)
	{
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping()
	public String home() 
	{
		return "Greetings";
	}

	@GetMapping("/cars")
	public List<Car> getAllCars() 
	{
		return this.reservationService.getAllCars();
	}

	
}
