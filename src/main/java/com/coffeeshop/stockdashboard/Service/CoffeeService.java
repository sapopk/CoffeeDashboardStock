package com.coffeeshop.stockdashboard.Service;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository repository) {
        this.coffeeRepository = repository;
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee createNewCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public void deleteCoffee(Integer coffeeID) {
        coffeeRepository.deleteById(coffeeID);
    }

    public Coffee updateCoffee(Coffee coffee) {
        int coffeeID = coffee.getCoffeeID();
        Coffee upCoffee = coffeeRepository.findById(coffeeID).orElseThrow(() -> new RuntimeException("Coffee not found"));
        upCoffee.setCoffeeBrand(coffee.getCoffeeBrand());
        upCoffee.setCoffeeType(coffee.getCoffeeType());
        upCoffee.setCoffeePrice(coffee.getCoffeePrice());
        upCoffee.setCoffeeQuantity(coffee.getCoffeeQuantity());
        
        return coffeeRepository.save(upCoffee);
    }
}
