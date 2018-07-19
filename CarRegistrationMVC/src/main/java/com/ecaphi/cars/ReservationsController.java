package com.ecaphi.cars;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ecaphi.cars.model.Car;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/cars")
public class ReservationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationsController.class);
	
	private ReservationService reservationService;
	
	@Autowired
	public ReservationsController(ReservationService reservationService)
	{
		super();
		this.reservationService = reservationService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping()
	public String home(Model model) {
		return "home";
	}
	
	/* Displays a form to input data. "Command" is a reserved request attribute, 
	 * which is used to display object data into the form. 
	 */
	@GetMapping("/addCars")
	public ModelAndView showform(){	
		return new ModelAndView("addCars", "command", new Car());
	}
	
	/* Saves object into database. The @ModelAttribute puts request data into the model object,
	 * You need to mention RequestMethod.POST because the default request is GET
	 */
	@RequestMapping(value="/addCars", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute(" ") Car car){
		this.reservationService.addCar(car);
		return new ModelAndView("redirect:viewCars"); //will redirect to viewCar request mapping
	}
	
	// provides list of cars in model object
	@GetMapping("/viewCars")
	public ModelAndView viewCars() {
		List<Car> list = this.reservationService.getAllCars();
		return new ModelAndView("viewCars", "list", list);
	}
	
	/* displays object data into form for the given car Id.
	 * The @PathVariable puts URL data into the variable.
	 */
	@RequestMapping(value="/editCars/{carId}")
	public ModelAndView edit(@PathVariable("carId") int carId){
		Car car = this.reservationService.getCarById(carId);
		return new ModelAndView("editCars", "car", car);
	}
	
	// updates model object
	@PostMapping(value="/editAndsave")
	public ModelAndView editsave(@ModelAttribute("car") Car car){
		this.reservationService.updateCar(car);
		return new ModelAndView("redirect:/cars/viewCars");
	}
	
	//deletes record for given Car Id in the URL and redirects to /viewCar
	@RequestMapping(value="/deleteCars/{carId}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int carId){
		this.reservationService.deleteCar(carId);
		return new ModelAndView("redirect:../viewCars");
	}	
}
