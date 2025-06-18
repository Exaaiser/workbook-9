package com.pluralsight.NorthwindTradersSpringBoot.dao;


import com.pluralsight.NorthwindTradersSpringBoot.models.Category;

import java.util.List;

public interface CategoryDAO {
    List<com.pluralsight.NorthwindTradersSpringBoot.models.Category> getAll();
    com.pluralsight.NorthwindTradersSpringBoot.models.Category getById(int id);
    com.pluralsight.NorthwindTradersSpringBoot.models.Category insert(com.pluralsight.NorthwindTradersSpringBoot.models.Category category); // ← Bunu ekle
}

