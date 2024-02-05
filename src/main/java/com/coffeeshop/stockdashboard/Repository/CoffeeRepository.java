package com.coffeeshop.stockdashboard.Repository;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {}
