package com.coffeeshop.stockdashboard.Coffee.Entity;

import com.coffeeshop.stockdashboard.Image.Entity.Image;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

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

    @Column(name = "coffeeID", nullable = false)
    private int coffeeID;

    @NotNull
    @Size(min = 1, max = 14, message = "Coffee's brand name must have min 1 & max 14 characters")
    @Column(name = "coffee_brand", nullable = false)
    private String coffeeBrand;

    @NotNull
    @Size(message = "Coffee's type name must have min 1 & max 14 characters")
    @Column(name = "coffee_type", nullable = false)
    private String coffeeType;

    @NotNull
    @Size(message = "Coffee's price must be clarified.")
    @Column(name = "coffee_price", nullable = false)
    private double coffeePrice;

    @NotNull
    @Size(min = 1, message = "Coffee's quantity cannot be empty.")
    @Column(name = "coffee_quantity", nullable = false)
    private int coffeeQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageID")
    private Image image;

    //Overload Constructor
    public Coffee() {}

    //Constructor
    public Coffee(String brandC, String typeC, double priceC, int quantityC) {
        this.coffeeBrand = brandC;
        this.coffeeType = typeC;
        this.coffeePrice = priceC;
        this.coffeeQuantity = quantityC;
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

    public Image getImage() {
        return image;
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

    public void setImage(Image image) {
        this.image = image;
    }
}