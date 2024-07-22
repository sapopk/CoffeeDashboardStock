CREATE DATABASE coffeeshop;

USE coffeeshop;

DROP TABLE coffee;
DROP TABLE coffee_image;
DROP TABLE coffee_sequence;
DROP TABLE image_sequence;

CREATE TABLE coffee (
   coffeeid INT NOT NULL UNIQUE,
   coffee_brand VARCHAR(50),
   coffee_price double,
   coffee_quantity int,
   coffee_type VARCHAR(50),
   imageid INT UNIQUE,
   PRIMARY KEY (CoffeeID),
   CONSTRAINT fk_coffee_image FOREIGN KEY (imageid) REFERENCES coffee_image(imageid) ON DELETE CASCADE
);

CREATE TABLE coffee_image (
    imageid INT NOT NULL UNIQUE,
	image_data BLOB,
    image_name_brand VARCHAR(255),
    image_type VARCHAR(255),
    image_size INT,
    image_upload_date DATETIME NOT NULL,
    PRIMARY KEY (imageID)
);
