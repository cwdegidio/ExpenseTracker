package com.cwdegidio.ExpenseTracker.service;

import com.cwdegidio.ExpenseTracker.model.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class CategoryMenuService {
    private static final HashMap<Integer, String> currentMenuOptions = new HashMap<>();
    private static Integer userChoice = 0;

    public static String generateTransactionMenu(Scanner scanner) {
        GeneralMenuService.generateHeader();

        currentMenuOptions.clear();
        currentMenuOptions.put(1, "categoriesViewAll");
        currentMenuOptions.put(2, "categoriesCreateNew");
        currentMenuOptions.put(3, "categoriesUpdateCategory");
        currentMenuOptions.put(4, "categoriesDeleteCategory");
        currentMenuOptions.put(5, "previousLocation");

        System.out.println(ansi().render("\n @|magenta Transaction Categories|@"));
        System.out.println("-----------------------------------------------------------------");
        System.out.println(ansi().render("1. @|cyan View all categories |@"));
        System.out.println(ansi().render("2. @|cyan Create new category |@"));
        System.out.println(ansi().render("3. @|cyan Update category |@"));
        System.out.println(ansi().render("4. @|cyan Delete category |@"));
        System.out.println(ansi().render("5. @|cyan Return to Main Menu |@"));

        System.out.println("\nEnter a selection: ");

        userChoice = Integer.parseInt(scanner.nextLine());

        return currentMenuOptions.get(userChoice);
    }

    public static void viewAllCategories(List<Category> categories, Scanner scanner) {

        GeneralMenuService.generateHeader();

        currentMenuOptions.clear();

        System.out.println(ansi().render("\n @|magenta Categories|@"));
        System.out.println("-----------------------------------------------------------------");

        for(Category category : categories) {
            System.out.printf("%s: %s%n", category.getId(), category.getName());
        }
        System.out.println("-- End of Categories --");
        System.out.println("\nPress any key to return to Categories menu.");
        scanner.nextLine();
    }

    public static String createNewCategory(Scanner scanner) {
        String categoryName;

        GeneralMenuService.generateHeader();

        currentMenuOptions.clear();

        System.out.println(ansi().render("\n @|magenta Create Category|@"));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Enter a category name: ");
        categoryName = scanner.nextLine();

        return categoryName;
    }
}
