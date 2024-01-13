package com.coffeeshop.stockdashboard.coffee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coffee")
public class Coffee {

    @Id
    private int ID;
    private String brand;
    private String type;
    private double pricePerKg;
    private double quantityInStock;
}
