package com.coffeeshop.stockdashboard.Service;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository repository) {
        this.coffeeRepository = repository;
    }

    @GetMapping
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    // @GetMapping
    // public List<Coffee> findCoffeeByID(Integer ID) {
    //     return coffeeRepository.findById(ID);
    // }
}
