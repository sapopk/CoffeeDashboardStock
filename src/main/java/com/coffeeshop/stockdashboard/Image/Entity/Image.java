package com.coffeeshop.stockdashboard.Image.Entity;

import java.sql.Blob;
import java.time.LocalDateTime;

import com.coffeeshop.stockdashboard.Coffee.Entity.Coffee;

import jakarta.persistence.*;

@Entity
@Table(name = "coffee_image", schema = "coffeeshop")
public class Image {

    @Id
    @SequenceGenerator(
        name = "image_sequence", 
        sequenceName = "image_sequence", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.TABLE, 
        generator = "image_sequence"
    )

    @Column(name = "imageID", nullable = false)
    private int imageID;

    @Lob
    @Column(name = "image_data")
    private Blob image;

    @Column(name = "image_name_brand", nullable = false)
    private String imageNameBrand;

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_size")
    private Integer imageSize;

    @Column(name = "image_upload_date", nullable = false)
    private LocalDateTime imageDate;

    @OneToOne(mappedBy = "image")
    @JoinColumn(name = "coffeeID")
    private Coffee coffee;

    //Overload Constructor
    public Image() {}

    public Image(Blob imageC, String brandC, String typeC, Integer sizeC, LocalDateTime dateC, Coffee coffeeC) {
        this.image = imageC;
        this.imageNameBrand = brandC;
        this.imageType = typeC;
        this.imageSize = sizeC;
        this.imageDate = dateC;
        this.coffee = coffeeC;
    }

    //Getters
    public int getImageID() {
        return imageID;
    }

    public Blob getImage() {
        return image;
    }

    public String getImageNameBrand() {
        return imageNameBrand;
    }

    public String getImageType() {
        return imageType;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public LocalDateTime getImageDate() {
        return imageDate;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    //Setters
    public void setImageID(int ID) {
        this.imageID = ID;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public void setImageNameBrand(String brand) {
        this.imageNameBrand = brand;
    }

    public void setImageType(String type) {
        this.imageType = type;
    }

    public void setImageSize(Integer size) {
        this.imageSize = size;
    }

    public void setImageDate(LocalDateTime date) {
        this.imageDate = date;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
