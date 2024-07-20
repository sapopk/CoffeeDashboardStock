package com.coffeeshop.stockdashboard.Coffee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coffeeshop.stockdashboard.Coffee.Entity.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    @Query("Select cof FROM Coffee cof WHERE cof.coffeeBrand = :keyword")
    public List<Coffee> searchByBrand(String keyword);

    @Query("Select cof FROM Coffee cof WHERE cof.coffeeID = :keyword")
    public List<Coffee> searchByID(int keyword);
}