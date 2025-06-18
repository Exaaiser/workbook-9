package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.dao.CategoryDAO;
import com.pluralsight.NorthwindTradersSpringBoot.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoryDAO categoryDao;

    @Autowired
    public CategoriesController(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }
}
