package com.cwdegidio.ExpenseTracker.dao;

import com.cwdegidio.ExpenseTracker.model.Category;

import java.sql.Connection;
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
    public List getAll() {

        return categories;
    }

    @Override
    public void save(Category category, Connection connection) {

    }

    @Override
    public void update(Category category, String[] params) {

    }

    @Override
    public void delete(Category category) {

    }
}
