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
        int searchID;
    
        if(search != null){
            if(search.matches("\\d+")) {
                try {
                    searchID = Integer.valueOf(search);
                    System.out.println("Converted Integer: " + searchID);
                    return coffeeRepository.searchByID(searchID);
                } catch (NumberFormatException nfe) {
                    System.err.println("Invalid convertion");
                }
            } else {
                return coffeeRepository.searchByBrand(search);
            }
        }
        return coffeeRepository.findAll();
    }

    public Coffee findCoffeeByID(Coffee coffee) {
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
        Coffee upCoffee = findCoffeeByID(coffee);

        upCoffee.setCoffeeBrand(coffee.getCoffeeBrand());
        upCoffee.setCoffeeType(coffee.getCoffeeType());
        upCoffee.setCoffeePrice(coffee.getCoffeePrice());
        upCoffee.setCoffeeQuantity(coffee.getCoffeeQuantity());
        
        return coffeeRepository.save(upCoffee);
    }
}
