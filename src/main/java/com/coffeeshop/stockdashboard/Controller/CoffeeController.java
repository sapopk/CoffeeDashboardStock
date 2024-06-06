package com.coffeeshop.stockdashboard.Controller;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class CoffeeController {

    @Autowired
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService service) {
        this.coffeeService = service;
    }

    @GetMapping("/api/coffee")
    public String getAllCoffees(Model model) {
        List<Coffee> coffee = coffeeService.getAllCoffees();
        model.addAttribute("coffees", coffee);
        return "index";
    }

    @PostMapping("/addCoffee")
    public String addNewCoffee(@ModelAttribute Coffee newCoffee) {
        coffeeService.saveNewCoffee(newCoffee);
        return "redirect:/api/coffee";
    }

    @PostMapping("/removeCoffee")
    public String removeCoffee(@PathVariable int coffeeID) {
        coffeeService.removeCoffee(coffeeID);
        return "redirect:/api/coffee";
    }
}