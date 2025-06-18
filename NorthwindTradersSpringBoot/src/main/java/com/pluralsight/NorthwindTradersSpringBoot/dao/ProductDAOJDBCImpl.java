package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAOJDBCImpl implements ProductDAO {
    private DataSource dataSource;

    @Autowired
    public ProductDAOJDBCImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<com.pluralsight.NorthwindTradersSpringBoot.models.Product> getAll() {
        return List.of();
    }

    @Override
    public com.pluralsight.NorthwindTradersSpringBoot.models.Product getById(int id) {
        return null;
    }

    @Override
    public com.pluralsight.NorthwindTradersSpringBoot.models.Product insert(com.pluralsight.NorthwindTradersSpringBoot.models.Product product) {
        String sql = "INSERT INTO products (product_name, supplier_id, category_id, quantity_per_unit, unit_price) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getSupplierId());
            ps.setInt(3, product.getCategoryId());
            ps.setString(4, product.getQuantityPerUnit());
            ps.setBigDecimal(5, product.getUnitPrice());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                product.setProductId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    // Diğer metotlar (getAll vs) gerekiyorsa daha sonra eklenebilir.
}
