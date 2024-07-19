package com.coffeeshop.stockdashboard.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coffee", schema = "coffeeshop")
public class Coffee {

    @Id
    @SequenceGenerator(
        name = "coffee_sequence",
        sequenceName = "coffee_sequence",
        allocationSize = 1
    )
    @GeneratedValue (
        strategy = GenerationType.TABLE,
        generator = "coffee_sequence"
    )

    @Column(name = "CoffeeID", nullable = false)
    private int coffeeID;
    @Column(name = "coffee_brand", nullable = false)
    private String coffeeBrand;
    @Column(name = "coffee_type", nullable = false)
    private String coffeeType;
    @Column(name = "coffee_price", nullable = false)
    private double coffeePrice;
    @Column(name = "coffee_quantity", nullable = false)
    private int coffeeQuantity;

    //Overload Constructor
    public Coffee() {}

    //Constructor
    public Coffee(String coffeeBrandC, String coffeeTypeC, double coffeePriceC, int coffeeQuantityC) {
        this.coffeeBrand = coffeeBrandC;
        this.coffeeType = coffeeTypeC;
        this.coffeePrice = coffeePriceC;
        this.coffeeQuantity = coffeeQuantityC;
    }

    //Getters
    public int getCoffeeID() {
        return coffeeID;
    }

    public String getCoffeeBrand() {
        return coffeeBrand;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public double getCoffeePrice() {
        return coffeePrice;
    }

    public int getCoffeeQuantity() {
        return coffeeQuantity;
    }

    //Setters
    public void setCoffeeID(int id) {
        this.coffeeID = id;
    }

    public void setCoffeeBrand(String brand) {
        this.coffeeBrand = brand;
    }

    public void setCoffeeType(String type) {
        this.coffeeType = type;
    }

    public void setCoffeePrice(double price) {
        this.coffeePrice = price;
    }

    public void setCoffeeQuantity(int quantity) {
        this.coffeeQuantity = quantity;
    }

    @Override
    public String toString() {
        return
                "Coffee{" +
                        "CoffeeID=" + coffeeID +
                        ", CoffeeBrand='" + coffeeBrand + '\'' +
                        ", CoffeeType='" + coffeeType + '\'' +
                        ", CoffeePrice=" + coffeePrice +
                        ", CoffeeQuantity=" + coffeeQuantity +
                        '}';
    }
}