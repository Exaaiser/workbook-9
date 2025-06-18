package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class CategoryDAOJDBCImpl implements CategoryDAO {
    private DataSource dataSource;

    @Autowired
    public CategoryDAOJDBCImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<com.pluralsight.NorthwindTradersSpringBoot.models.Category> getAll() {
        return List.of();
    }

    @Override
    public com.pluralsight.NorthwindTradersSpringBoot.models.Category getById(int id) {
        return null;
    }

    @Override
    public com.pluralsight.NorthwindTradersSpringBoot.models.Category insert(com.pluralsight.NorthwindTradersSpringBoot.models.Category category) {
        String sql = "INSERT INTO categories (category_name, description) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getCategoryId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                category.setCategoryId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }
}
