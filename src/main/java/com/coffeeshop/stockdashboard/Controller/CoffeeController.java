package com.coffeeshop.stockdashboard.Controller;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CoffeeController {

    @Autowired
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService service) {
        this.coffeeService = service;
    }

    // @GetMapping("/api/coffee")
    // public String getAllCoffee(Model model) {
    // List<Coffee> coffee = coffeeService.getAllCoffee();
    // model.addAttribute("coffee", coffee);
    // return "index";
    // }

    // // @PostMapping("/addCoffee")
    // // public String getAddCoffee(@ModelAttribute Coffee addCoffee) {
    // // coffeeService.saveNewCoffee(addCoffee);
    // // return "redirect:/api/coffee";
    // // }

    // @PostMapping("/coffee")
    // public String submitAddCoffeeForm(@ModelAttribute Coffee addCoffee,
    // BindingResult result) {
    // if (result.hasErrors()) {
    // return "index"; // Or the appropriate view name
    // }
    // // Process the form
    // return "redirect:/success"; // Redirect to a success page or similar
    // }


    // @PostMapping("/addCoffee")
    // public String addCoffee(@ModelAttribute Coffee coffee) {
    // coffeeService.saveNewCoffee(coffee); // Add the coffee to the
    // service/repository
    // return "redirect:/"; // Redirect to avoid duplicate form submissions
    // }

    @GetMapping("/api/coffee")
    public String index(Model model) {
        model.addAttribute("coffee", new Coffee()); // Initialize the coffee object
        model.addAttribute("coffees", coffeeService.getAllCoffee()); // Add the list
        return "index";
    }

    // @PostMapping("/addCoffee")
    // public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee) {
    //     System.out.println(coffee.toString());
    //     Coffee newCoffee = coffeeService.saveNewCoffee(coffee);
    //     return ResponseEntity.ok(newCoffee);
    // }

    // @PostMapping("/addCoffee")
    // public String addCoffee(@ModelAttribute Coffee coffee) {
    //     System.out.println(coffee.toString());
    //     coffeeService.saveNewCoffee(coffee); // Add the coffee to the service/repository
    //     return "redirect:/api/coffee"; // Redirect to avoid duplicate form submissions
    // }

    @PostMapping("/addCoffee")
    public String addCoffee(@ModelAttribute("addCoffee") Coffee coffee) {
        System.out.println(coffee.toString());
        coffeeService.saveNewCoffee(coffee);
        return "redirect:/api/coffee";
    }
    
}