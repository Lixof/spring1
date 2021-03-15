package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.3.4 version by mar'21 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {

		List<Car> cars = new ArrayList<>();
		for (int i = 1 ; i < 6 ; i++) {
			cars.add(new Car("User" + i, "Model" + i, i));
		}

		int sum = CarServiceImp.sumCars(cars);
		if (count == null || count > sum) count = sum;

		List<Car> cars1 = new ArrayList<>();
		for (int i = 0 ; i < count ; i++){ cars1.add(cars.get(i)); }

		model.addAttribute("cars", cars1);

		return "cars";
	}

}