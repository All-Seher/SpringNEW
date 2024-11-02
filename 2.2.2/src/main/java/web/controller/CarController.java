package web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import web.Service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/startPages")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String cars() {
        return "startPage";
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(name = "count", required = false) int count, Model model) {
        model.addAttribute("cars", carService.getLimitCars(count));
        return "cars";
    }
}
