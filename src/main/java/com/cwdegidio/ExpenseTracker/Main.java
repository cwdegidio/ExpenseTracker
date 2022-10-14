package com.cwdegidio.ExpenseTracker;

import com.cwdegidio.ExpenseTracker.dao.CategoryDao;
import com.cwdegidio.ExpenseTracker.model.AppState;
import com.cwdegidio.ExpenseTracker.model.Category;
import com.cwdegidio.ExpenseTracker.service.CategoryMenuService;
import com.cwdegidio.ExpenseTracker.service.GeneralMenuService;
import com.cwdegidio.ExpenseTracker.service.DBService;
import com.cwdegidio.ExpenseTracker.service.InitializationService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        AppState appState = new AppState();
        String dbName = "expense.db";

        InitializationService.createNewDatabase(dbName, DBService.connect(dbName));
        InitializationService.initializeTables(DBService.connect(dbName));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String location = appState.getCurrentLocation();
            String nextLocation;

            if (location.equals("categories")) {
                nextLocation = CategoryMenuService.generateTransactionMenu(scanner);

                if (nextLocation.equals("previousLocation")) {
                    appState.removeLastLocationFromHistory();
                } else {
                    appState.addLocationToHistory(nextLocation);
                }

            } else if (location.equals("categoriesViewAll")) {
                CategoryDao categoryDao = new CategoryDao();
                List<Category> categories = categoryDao.getAll(DBService.connect(dbName));

                CategoryMenuService.viewAllCategories(categories, scanner);
                appState.removeLastLocationFromHistory();

            } else if (location.equals("categoriesCreateNew")) {
                String categoryName = CategoryMenuService.createNewCategory(scanner);
                System.out.printf("Create new category: %s!%n", categoryName);

                Category category = new Category(categoryName);
                CategoryDao categoryDao = new CategoryDao();
                categoryDao.save(category, DBService.connect(dbName));

                appState.removeLastLocationFromHistory();

            }else {
                nextLocation = GeneralMenuService.generateMainMenu(scanner);
                appState.addLocationToHistory(nextLocation);
            }
        }
    }
}
