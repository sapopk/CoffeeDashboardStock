package com.coffeeshop.stockdashboard.Image.Service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    public Image saveImage(Image image){
        return imageRepository.save(image);
    }

    public Image viewImageById(int id) {
        return imageRepository.findById(id).get();
    }

    public ResponseEntity<byte[]> displayImage(int imageID) throws IOException, SQLException {
        Image image = viewImageById(imageID);
        byte [] imageBytes = null;
        imageBytes = image.getImage().getBytes(1, (int)image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getImageType())).body(imageBytes);
    }
}
