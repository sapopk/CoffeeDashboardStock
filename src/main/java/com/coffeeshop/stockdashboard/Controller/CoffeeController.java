package com.coffeeshop.stockdashboard.Controller;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class CoffeeController {

    @Autowired
    private final CoffeeService coffeeService;

    private String redirectIndex = "redirect:/api/coffee";

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
        coffeeService.createNewCoffee(newCoffee);
        return redirectIndex;
    }

    @PostMapping("/removeCoffee") 
    public String removeCoffee(Integer coffeeID) {
        coffeeService.deleteCoffee(coffeeID);
        return redirectIndex;
    }

    // @PostMapping("/modifyCoffee")
    // public String modifyCoffee(Coffee coffee) {
    //     return redirectIndex;
    // }  
}