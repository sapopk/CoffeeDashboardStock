CREATE DATABASE coffeeshop;

CREATE TABLE coffee (
   CoffeeID INT NOT NULL,
   coffee_brand VARCHAR(50),
   coffee_type VARCHAR(50),
   coffee_price double,
   coffee_quantity double DEFAULT 0.0,
   PRIMARY KEY (ID)
);

INSERT INTO coffee(CoffeeID, coffee_brand, type, coffee_price, coffee_quantity) VALUES(1, "Lavazza", "arabica", 23.50, 10.55);
INSERT INTO coffee(CoffeeID, coffee_brand, type, coffee_price, coffee_quantity) VALUES(2, "Death Wish", "robusta", 21.75, 7);
INSERT INTO coffee(CoffeeID, coffee_brand, type, coffee_price, coffee_quantity) VALUES(3, "Intelligentsia", "liberica", 29.99, 3.20);