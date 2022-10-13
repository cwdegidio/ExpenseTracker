package com.cwdegidio.ExpenseTracker.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get (int id);

    List<T> getAll();

    void save (T t, Connection connection);

    void update(T t, String[] params);

    void delete (T t);

}
