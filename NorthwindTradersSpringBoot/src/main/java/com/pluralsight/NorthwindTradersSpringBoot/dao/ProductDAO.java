package com.pluralsight.NorthwindTradersSpringBoot.dao;


import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.List;

public interface ProductDAO {
    List<com.pluralsight.NorthwindTradersSpringBoot.models.Product> getAll();
    com.pluralsight.NorthwindTradersSpringBoot.models.Product getById(int id);
    com.pluralsight.NorthwindTradersSpringBoot.models.Product insert(com.pluralsight.NorthwindTradersSpringBoot.models.Product product); // ← Bunu ekle
}
