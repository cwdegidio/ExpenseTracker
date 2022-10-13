package com.cwdegidio.ExpenseTracker.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBService {

    public static Connection connect(String database) {

        String userDir = System.getProperty("user.home");
        String url = "jdbc:sqlite:" + userDir + "/.expense_tracker/sqlite/db/" + database;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    //    public void insert(BigDecimal amount, String reference, String type) {
//        String sql = "INSERT INTO expenses(amount, reference, type) VALUES(?,?,?)";
//
//        try (Connection connection = this.connect();
//             PreparedStatement prepStmnt = connection.prepareStatement(sql)) {
//
//            prepStmnt.setBigDecimal(1, amount);
//            prepStmnt.setString(2, reference);
//            prepStmnt.setString(3, type);
//
//            prepStmnt.executeUpdate();
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
