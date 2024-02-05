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
    private int CoffeeID;
    @Column(name = "coffee_brand", nullable = false)
    private String CoffeeBrand;
    @Column(name = "coffee_type", nullable = false)
    private String CoffeeType;
    @Column(name = "coffee_price", nullable = false)
    private double CoffeePrice;
    @Column(name = "coffee_quantity", nullable = false)
    private double CoffeeQuantity;

    //Overload Constructor
    public Coffee() {}

    //Constructor
    public Coffee(String coffeeBrand, String coffeeType, double coffeePrice, double coffeeQuantity) {
        this.CoffeeBrand = coffeeBrand;
        this.CoffeeType = coffeeType;
        this.CoffeePrice = coffeePrice;
        this.CoffeeQuantity = coffeeQuantity;
    }

    //Getters
    public int getCoffeeID() {
        return CoffeeID;
    }

    public String getCoffeeBrand() {
        return CoffeeBrand;
    }

    public String getCoffeeType() {
        return CoffeeType;
    }

    public double getCoffeePrice() {
        return CoffeePrice;
    }

    public double getCoffeeQuantity() {
        return CoffeeQuantity;
    }

    //Setters
    public void setCoffeeID(int coffeeID) {
        CoffeeID = coffeeID;
    }

    public void setCoffeeBrand(String coffeeBrand) {
        CoffeeBrand = coffeeBrand;
    }

    public void setCoffeeType(String coffeeType) {
        CoffeeType = coffeeType;
    }

    public void setCoffeePrice(double coffeePrice) {
        CoffeePrice = coffeePrice;
    }

    public void setCoffeeQuantity(double coffeeQuantity) {
        CoffeeQuantity = coffeeQuantity;
    }

    @Override
    public String toString() {
        return
                "Coffee{" +
                        "CoffeeID=" + CoffeeID +
                        ", CoffeeBrand='" + CoffeeBrand + '\'' +
                        ", CoffeeType='" + CoffeeType + '\'' +
                        ", CoffeePrice=" + CoffeePrice +
                        ", CoffeeQuantity=" + CoffeeQuantity +
                        '}';
    }
}


