package com.coffeeshop.stockdashboard.Repository;

import com.coffeeshop.stockdashboard.Entity.Coffee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    @Query("SELECT cof FROM Coffee cof WHERE CONCAT(cof.coffeeID, ' ', cof.coffeeBrand, ' ', cof.coffeeType, ' ', cof.coffeePrice, ' ', cof.coffeeQuantity) LIKE %:keyword%")
    public List<Coffee> search(String keyword);
}