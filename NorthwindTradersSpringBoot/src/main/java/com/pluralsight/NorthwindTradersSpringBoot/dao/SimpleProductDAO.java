package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO {
    private List<Product> products = new ArrayList<>();

    public SimpleProductDAO() {
        // Örnek veriler
        products.add(new Product(1, "Laptop", "Electronics", 999.99));
        products.add(new Product(2, "Headphones", "Electronics", 199.99));
        products.add(new Product(3, "Coffee Mug", "Kitchen", 12.49));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
