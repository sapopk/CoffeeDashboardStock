package com.coffeeshop.stockdashboard.Image.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.coffeeshop.stockdashboard.Image.Service.ImageService;

public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService service) {
        this.imageService = service;
    }
}
