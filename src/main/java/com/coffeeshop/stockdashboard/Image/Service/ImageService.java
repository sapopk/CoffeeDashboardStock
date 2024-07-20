package com.coffeeshop.stockdashboard.Image.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.stockdashboard.Image.Entity.Image;
import com.coffeeshop.stockdashboard.Image.Repository.ImageRepository;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository repository){
        this.imageRepository = repository;
    }

    public Image create(Image image){
        return imageRepository.save(image);
    }
}
