package com.coffeeshop.stockdashboard.Config;

import com.coffeeshop.stockdashboard.Entity.Coffee;
import com.coffeeshop.stockdashboard.Repository.CoffeeRepository;
import org.springframework.boot .CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CoffeeConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(CoffeeRepository repository) {
//        return args -> {
//            Coffee pele = new Coffee(
//                    "Pele",
//                    "Black Strong",
//                    334,
//                    3033
//            );
//            Coffee maria = new Coffee(
//                    "Maria",
//                    "Black Strong",
//                    334,
//                    3033
//            );

//            repository.saveAll(
//                    List.of(pele, maria)
//            );
//        };
//    }
}
