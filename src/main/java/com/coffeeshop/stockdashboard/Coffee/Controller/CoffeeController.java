package com.coffeeshop.stockdashboard.Coffee.Controller;

import com.coffeeshop.stockdashboard.Coffee.Entity.Coffee;
import com.coffeeshop.stockdashboard.Coffee.Service.CoffeeService;
import com.coffeeshop.stockdashboard.Image.Entity.Image;
import com.coffeeshop.stockdashboard.Image.Service.ImageService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final ImageService imageService;

    private String redirectIndex = "redirect:/api/coffee";
    
    @Autowired
    public CoffeeController(CoffeeService coffeeService, ImageService imageService) {
        this.coffeeService = coffeeService;
        this.imageService = imageService;
    }

    @GetMapping("/api/coffee")
    public String getAllCoffees(Model model,
    @Param("search") String search, 
    @Param("filter") String filter, 
    @Param("direction") String direction) {
        List<Coffee> coffee;

        Map<String, String> sortOptions = new LinkedHashMap<>();
        sortOptions.put("Number", "coffeeID");
        sortOptions.put("Brand", "coffeeBrand");
        sortOptions.put("Type", "coffeeType");
        sortOptions.put("Price", "coffeePrice");
        sortOptions.put("Quantity", "coffeeQuantity");

        Map<String, String> sortDirection = new LinkedHashMap<>();
        sortDirection.put("Ascending", "ASC");
        sortDirection.put("Descending", "DESC");

        if(filter != null) {
            coffee = coffeeService.filterByTopicAndSortByAscOrDesc(filter, direction);
        } else {
            coffee = coffeeService.getAllCoffees(search);
        }

        model.addAttribute("sortOptions", sortOptions);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("coffees", coffee);
        return "index";
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@Param("imageID") int imageID) throws IOException, SQLException {
        return imageService.displayImage(imageID);
    }
    
    @PostMapping("/addCoffee")
    public String addNewCoffee(
    @ModelAttribute Coffee coffee, 
    MultipartFile file) throws SerialException, IOException, SQLException {
        coffeeService.createCoffee(coffee, file);
        return redirectIndex;
    }
    
    @PostMapping("/removeCoffee") 
    public String removeCoffee(Integer coffeeID) {
        coffeeService.deleteCoffee(coffeeID);
        return redirectIndex;
    }

    @PostMapping("/modifyCoffee")
    public String modifyCoffee(Coffee coffee, MultipartFile file) throws SerialException, IOException, SQLException {
        coffeeService.updateCoffee(coffee, file);
        return redirectIndex;
    }
}