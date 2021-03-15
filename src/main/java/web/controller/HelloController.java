package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(ModelMap model) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Evgeniy", "Peugeot", 874 ));
		cars.add(new Car("Nikita", "Hyundai", 675 ));
		cars.add(new Car("Natasha", "Opel", 490));
		cars.add(new Car("Lida", "Nissan", 471 ));
		cars.add(new Car("Slava", "Volvo", 983 ));
		return "cars";
	}

}