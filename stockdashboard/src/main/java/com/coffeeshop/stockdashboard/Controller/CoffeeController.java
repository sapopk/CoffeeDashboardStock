package com.coffeeshop.stockdashboard.Controller;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class CoffeeController {

    @Autowired
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService service) {
        this.coffeeService = service;
    }

    @GetMapping("/api/v2/coffee")
    public String getAllCoffee(Model model) {
        List<Coffee> coffee = coffeeService.getAllCoffee();
        model.addAttribute("coffee", coffee);
        return "index";
    }

    // @GetMapping("api/v2/coffee/table")
    // public String coffeeList(Model model) {
    //     List<Coffee> list = coffeeService.getAllCoffee();
    //     model.addAttribute("list", list);
    //     return "coffee-list";
    // }

}
