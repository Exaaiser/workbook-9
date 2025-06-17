// src/main/java/com/pluralsight/NorthwindTradersAPI/controllers/ProductsController.java
package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @GetMapping
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(1, "Chai", 1, 18.0),
                new Product(2, "Chang", 1, 19.0)
        );
    }
}
