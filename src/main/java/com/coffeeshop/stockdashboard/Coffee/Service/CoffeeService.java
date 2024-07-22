package com.coffeeshop.stockdashboard.Coffee.Service;

import com.coffeeshop.stockdashboard.Coffee.Entity.Coffee;
import com.coffeeshop.stockdashboard.Coffee.Repository.CoffeeRepository;
import com.coffeeshop.stockdashboard.Image.Entity.Image;
import com.coffeeshop.stockdashboard.Image.Service.ImageService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final ImageService imageService;

    @Autowired
    public CoffeeService(CoffeeRepository repository, ImageService service) {
        this.coffeeRepository = repository;
        this.imageService = service;
    }

    public List<Coffee> getAllCoffees(String search) {
        if(search != null) {
            return getSearchCoffeeByIdOrBrand(search);
        }
        return coffeeRepository.findAll();
    }

    public List<Coffee> filterByTopicAndSortByAscOrDesc(String filter, String direction) {
        String sortBy = (filter == null || filter.isEmpty()) ? "coffeeID" : filter;
        Sort.Direction sortDirection = "DESC".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        return coffeeRepository.findAll(Sort.by(sortDirection, sortBy));
    }

    public List<Coffee> getSearchCoffeeByIdOrBrand(String search) {
        int searchID;
    
        if(search != null){
            if(search.matches("\\d+")) {
                try {
                    searchID = Integer.valueOf(search);
                    return coffeeRepository.searchByID(searchID);
                } catch (NumberFormatException nfe) {
                    System.err.println("Invalid convertion");
                }
            } else {
                return coffeeRepository.searchByBrand(search);
            }
        } 
        return null;
    }

    public Coffee findCoffeeByID(Coffee coffee) {
        int coffeeID = coffee.getCoffeeID();

        if(coffeeID <= 0) {
            return null;
        }

        return coffeeRepository.findById(coffeeID).get();
    }

    private Image createImage(String coffeeBrand, MultipartFile file) throws IOException, SerialException, SQLException {
        Image image = new Image();
        
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        
        image.setImage(blob);
        image.setImageNameBrand(coffeeBrand);
        image.setImageType(file.getContentType());
        image.setImageSize((int) file.getSize());
        image.setImageDate(LocalDateTime.now());
        
        return imageService.saveImage(image);
    }

    public Coffee createCoffee(Coffee coffee, MultipartFile file) throws IOException, SerialException, SQLException {
        Image image = createImage(coffee.getCoffeeBrand(), file);
        coffee.setImage(image);
        return coffeeRepository.save(coffee);
    }

    public void deleteCoffee(Integer coffeeID) {
        coffeeRepository.deleteById(coffeeID);
    }

    public Coffee updateCoffee(Coffee coffee, MultipartFile file) throws IOException, SerialException, SQLException {
        Image image = createImage(coffee.getCoffeeBrand(), file);
        coffee.setImage(image);
        
        Coffee upCoffee = findCoffeeByID(coffee);

        upCoffee.setCoffeeBrand(coffee.getCoffeeBrand());
        upCoffee.setCoffeeType(coffee.getCoffeeType());
        upCoffee.setCoffeePrice(coffee.getCoffeePrice());
        upCoffee.setCoffeeQuantity(coffee.getCoffeeQuantity());
        
        return coffeeRepository.save(upCoffee);
    }
}
