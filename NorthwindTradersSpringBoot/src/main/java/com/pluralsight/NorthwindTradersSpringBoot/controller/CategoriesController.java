// src/main/java/com/pluralsight/NorthwindTradersAPI/controllers/CategoriesController.java
package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @GetMapping
    public List<Category> getAllCategories() {
        return Arrays.asList(
                new Category(1, "Beverages"),
                new Category(2, "Condiments")
        );
    }
}
