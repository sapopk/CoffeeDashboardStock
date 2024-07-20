package com.coffeeshop.stockdashboard.Coffee.Service;

import com.coffeeshop.stockdashboard.Coffee.Entity.Coffee;
import com.coffeeshop.stockdashboard.Coffee.Repository.CoffeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository repository) {
        this.coffeeRepository = repository;
    }

    public List<Coffee> getAllCoffees(String search) {
        if(search != null) {
            return getSearchCoffeeByIdOrBrand(search);
        }
        return coffeeRepository.findAll();
    }

    public List<Coffee> filterByTopicAndSortByAscOrDesc(String filter, String direction) {
        String sortBy = (filter == null || filter.isEmpty()) ? "coffeeID" : filter;
        Sort.Direction sortDirection = "DESC".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        return coffeeRepository.findAll(Sort.by(sortDirection, sortBy));
    }

    public List<Coffee> getSearchCoffeeByIdOrBrand(String search) {
        int searchID;
    
        if(search != null){
            if(search.matches("\\d+")) {
                try {
                    searchID = Integer.valueOf(search);
                    return coffeeRepository.searchByID(searchID);
                } catch (NumberFormatException nfe) {
                    System.err.println("Invalid convertion");
                }
            } else {
                return coffeeRepository.searchByBrand(search);
            }
        } 
        return null;
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
        System.out.println(coffee);
        Coffee upCoffee = findCoffeeByID(coffee);

        upCoffee.setCoffeeBrand(coffee.getCoffeeBrand());
        upCoffee.setCoffeeType(coffee.getCoffeeType());
        upCoffee.setCoffeePrice(coffee.getCoffeePrice());
        upCoffee.setCoffeeQuantity(coffee.getCoffeeQuantity());
        
        return coffeeRepository.save(upCoffee);
    }
}
