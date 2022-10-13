package com.cwdegidio.ExpenseTracker;

import org.sqlite.SQLiteConfig;

import java.io.File;
import java.sql.*;
import java.util.Properties;

public class SqliteConnect {

    public static void createNewTable(String filename) {

        String userDir = System.getProperty("user.home");
        String url = "jdbc:sqlite:" + userDir + "/.expense_tracker/sqlite/db/" + filename;

        String sqlCat = "CREATE TABLE IF NOT EXISTS categories (\n"
                + "id INTEGER PRIMARY KEY, \n"
                + "name TEXT NOT NULL"
                + ");";

        String sqlType = "CREATE TABLE IF NOT EXISTS types (\n"
                + "id INTEGER PRIMARY KEY, \n"
                + "name TEXT NOT NULL"
                + ");";

        String sqlExp = "CREATE TABLE IF NOT EXISTS expenses (\n"
                + "id INTEGER PRIMARY KEY, \n"
                + "amount REAL NOT NULL, \n"
                + "reference TEXT NOT NULL, \n"
                + "date INTEGER NOT NULL, \n"
                + "category INTEGER NOT NULL, \n"
                + "type INTEGER NOT NULL, \n"
                + "FOREIGN KEY (category) REFERENCES categories (id), \n"
                + "FOREIGN KEY (type) REFERENCES types (id)"
                +");";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.execute(sqlCat);
            System.out.println("Categories table Created");
            statement.execute(sqlType);
            System.out.println("Types table created.");
            statement.execute(sqlExp);
            System.out.println("Expenses table created");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewDatabase(String filename) {
        String userHomeDir = System.getProperty("user.home");
        String appDir = userHomeDir + "/.expense_tracker/sqlite/db";

        File tmpDir = new File(appDir);
        boolean dirExists = tmpDir.isDirectory();

        if (!dirExists) {
            boolean created = tmpDir.mkdirs();

            if (created) {
                System.out.println("~/.expense_tracker/sqlite/db has been created.");
            }
        }


        String userDir = System.getProperty("user.home");
        String url = "jdbc:sqlite:" + userDir + "/.expense_tracker/sqlite/db/" + filename;

        try (Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();

                System.out.println("The Driver name is " + meta.getDriverName());
                System.out.println("A new database has been created");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection connect(String filename) {
        Connection connection = null;

        try {
            String userDir = System.getProperty("user.home");
            String url = "jdbc:sqlite:" + userDir + "/.expense_tracker/sqlite/db/" + filename;

            connection = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
