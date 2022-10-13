package com.cwdegidio.ExpenseTracker.service;

import java.io.File;
import java.sql.*;

public class InitializationService {

    public static void createNewDatabase(String filename, Connection connection) {
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

        String dbFilePath = appDir + "/" + filename;
        File file = new File(dbFilePath);

        boolean fileExists = file.isFile();

        if (!fileExists) {
            try (connection) {
                if (connection != null && file.isFile()) {
                    System.out.println("A new database has been created");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Database is available.");
        }
    }

    public static void initializeTables(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        if (!tableExists(connection, "types")) {
            String sqlCat = "CREATE TABLE IF NOT EXISTS types (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name TEXT NOT NULL"
                    + ");";

            statement.execute(sqlCat);
            System.out.println("Type table initialized.");
        }

        if (!tableExists(connection, "categories")) {
            String sqlType = "CREATE TABLE IF NOT EXISTS categories (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name TEXT NOT NULL"
                    + ");";

            statement.execute(sqlType);
            System.out.println("Category table initialized.");
        }

        if (!tableExists(connection, "expenses")) {
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

            statement.execute(sqlExp);
            System.out.println("Expense table initialized.");
        }

        connection.close();

    }

    private static boolean tableExists(Connection connection, String tableName) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) "
            + "FROM sqlite_master "
            + "WHERE tbl_name = ?"
            + " LIMIT 1;");

        preparedStatement.setString(1, tableName);
        System.out.println("In the query");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println("resultSet.next(): " + resultSet.getInt(1));
        return resultSet.getInt(1) != 0;
    }

}
