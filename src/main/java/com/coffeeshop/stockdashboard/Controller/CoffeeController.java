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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;

    private String redirectIndex = "redirect:/api/coffee";
    
    @Autowired
    public CoffeeController(CoffeeService service) {
        this.coffeeService = service;
    }

    @GetMapping("/api/coffee")
    public String getAllCoffees(Model model,
    @Param("search") String search, 
    @Param("filter") String filter, 
    @Param("direction") String direction) {
        List<Coffee> coffee;

        Map<String, String> sortOptions = new LinkedHashMap<>();
        sortOptions.put("Number", "coffeeID");
        sortOptions.put("Brand", "coffeeBrand");
        sortOptions.put("Type", "coffeeType");
        sortOptions.put("Price", "coffeePrice");
        sortOptions.put("Quantity", "coffeeQuantity");

        Map<String, String> sortDirection = new LinkedHashMap<>();
        sortDirection.put("Ascending", "ASC");
        sortDirection.put("Descending", "DESC");

        if(filter != null) {
            coffee = coffeeService.filterByTopicAndSortByAscOrDesc(filter, direction);
        } else {
            coffee = coffeeService.getAllCoffees(search);
        }

        model.addAttribute("sortOptions", sortOptions);
        model.addAttribute("sortDirection", sortDirection);
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

    @PostMapping("/modifyCoffee")
    public String modifyCoffee(Coffee coffee) {
        coffeeService.updateCoffee(coffee);
        return redirectIndex;
    }
}