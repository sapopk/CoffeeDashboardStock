package com.coffeeshop.stockdashboard.Controller;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService service) {
        this.coffeeService = service;
    }

    @GetMapping
    public List<Coffee> getAllCoffee() {
        return coffeeService.getAllCoffee();
    }
}
