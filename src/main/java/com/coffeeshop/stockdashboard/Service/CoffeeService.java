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

    public List<Coffee> getAllCoffees(String search) {
        if(search != null){
            return coffeeRepository.search(search);
        }
        return coffeeRepository.findAll();
    }

    public Coffee findCoffeByID(Coffee coffee) {
        int coffeeID = coffee.getCoffeeID();

        if(coffeeID <= 0) {
            return null;
        }

        return coffeeRepository.findById(coffeeID).get();
    }

    public Coffee createNewCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public void deleteCoffee(Integer coffeeID) {
        coffeeRepository.deleteById(coffeeID);
    }

    public Coffee updateCoffee(Coffee coffee) {
        Coffee upCoffee = findCoffeByID(coffee);

        upCoffee.setCoffeeBrand(coffee.getCoffeeBrand());
        upCoffee.setCoffeeType(coffee.getCoffeeType());
        upCoffee.setCoffeePrice(coffee.getCoffeePrice());
        upCoffee.setCoffeeQuantity(coffee.getCoffeeQuantity());
        
        return coffeeRepository.save(upCoffee);
    }

    // public List<Coffee> searchCoffee(String search) {
    //     if(search != null) {
    //         return coffeeRepository.findAll(search);
    //     }
    //     return coffeeRepository.findAll();
    // }
}
