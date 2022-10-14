package com.cwdegidio.ExpenseTracker.dao;

import com.cwdegidio.ExpenseTracker.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao implements Dao<Category> {

    private List<Category> categories = new ArrayList<>();

    @Override
    public Optional<Category> get(int id) {
        return Optional.ofNullable(categories.get(id));
    }

    @Override
    public List<Category> getAll(Connection connection) {
        categories.clear();

        String sql = "SELECT * from categories";

        try (connection;
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            while (results.next()) {
                int categoryId = results.getInt("id");
                String categoryName = results.getString("name");
                Category category = new Category(categoryId, categoryName);

                categories.add(category);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return categories;
    }

    @Override
    public void save(Category category, Connection connection) {
        String sql = "INSERT INTO categories(name) VALUES(?)";

        try (connection;
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, category.getName());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Category category, String[] params) {

    }

    @Override
    public void delete(Category category) {

    }
}
