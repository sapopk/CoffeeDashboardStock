CREATE DATABASE coffeeshop;

USE coffeeshop;

SELECT * FROM COFFEE;
SELECT * FROM COFFEE_SEQUENCE;

CREATE TABLE coffee (
   CoffeeID INT NOT NULL,
   coffee_brand VARCHAR(50),
   coffee_type VARCHAR(50),
   coffee_price double,
   coffee_quantity int,
   PRIMARY KEY (CoffeeID)
);

INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(1, "Lavazza", "arabica", 23.50, 10);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(2, "Death Wish", "robusta", 21.75, 7);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(3, "Intelligentsia", "liberica", 29.99, 3);

INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(4, "Starbucks", "arabica", 19.99, 15);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(5, "Blue Bottle", "arabica", 27.50, 8);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(6, "Peet's Coffee", "robusta", 22.00, 12);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(7, "Stumptown", "liberica", 24.99, 5);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(8, "Caribou Coffee", "arabica", 20.75, 10);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(9, "Dunkin' Donuts", "robusta", 18.50, 20);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(10, "Green Mountain", "liberica", 26.00, 6);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(11, "Nespresso", "arabica", 25.75, 11);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(12, "Gevalia", "robusta", 23.00, 9);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(13, "Seattle's Best", "liberica", 22.50, 7);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(14, "Kicking Horse", "arabica", 28.00, 4);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(15, "Community Coffee", "robusta", 21.25, 10);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(16, "Eight O'Clock", "liberica", 19.50, 12);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(17, "Tully's Coffee", "arabica", 24.25, 6);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(18, "Peaberry", "robusta", 20.50, 14);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(19, "Gloria Jean's", "liberica", 27.00, 5);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(20, "Tim Hortons", "arabica", 22.75, 9);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(21, "Costa Coffee", "robusta", 23.50, 8);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(22, "Jacobs", "liberica", 28.50, 7);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(23, "Maxwell House", "arabica", 18.75, 16);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(24, "Folgers", "robusta", 19.99, 18);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(25, "McCafe", "liberica", 21.50, 13);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(26, "Nescafe", "arabica", 24.00, 9);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(27, "Pilao", "robusta", 22.25, 12);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(28, "Illy", "liberica", 29.00, 6);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(29, "Lavazza", "arabica", 25.00, 10);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(30, "Bulletproof", "robusta", 21.50, 8);
INSERT INTO coffee(CoffeeID, coffee_brand, coffee_type, coffee_price, coffee_quantity) VALUES(31, "Café Bustelo", "liberica", 23.99, 9);
