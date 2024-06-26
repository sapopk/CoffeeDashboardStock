package com.coffeeshop.stockdashboard.Controller;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Service.CoffeeService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;

    private String redirectIndex = "redirect:/api/coffee";
    
    @Autowired
    public CoffeeController(CoffeeService service) {
        this.coffeeService = service;
    }

    @GetMapping("/api/coffee")
    public String getAllCoffees(Model model, @Param("search") String search) {
        List<Coffee> coffee = coffeeService.getAllCoffees(search);
        model.addAttribute("coffees", coffee);
        model.addAttribute("search", search);
        return "index";
    }
    
    @PostMapping("/addCoffee")
    public String addNewCoffee(@ModelAttribute Coffee newCoffee) {
        coffeeService.createNewCoffee(newCoffee);

        return redirectIndex;
    }

    @PostMapping("/removeCoffee") 
    public String removeCoffee(Integer coffeeID) {
        coffeeService.deleteCoffee(coffeeID);

        return redirectIndex;
    }

    @PostMapping("/modifyCoffee")
    public String modifyCoffee(Coffee coffee) {
        coffeeService.updateCoffee(coffee);

        return redirectIndex;
    }
}