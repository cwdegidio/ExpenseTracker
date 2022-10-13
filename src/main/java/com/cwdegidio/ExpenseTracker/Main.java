package com.cwdegidio.ExpenseTracker;

import com.cwdegidio.ExpenseTracker.model.AppState;
import com.cwdegidio.ExpenseTracker.service.CliMenuService;
import com.cwdegidio.ExpenseTracker.service.DBService;
import com.cwdegidio.ExpenseTracker.service.InitializationService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;


public class Main {
    public static void main(String[] args) throws SQLException {

        AppState appState = new AppState();

        CliMenuService.generateWelcomeHeader();

        String dbName = "expense.db";

        InitializationService.createNewDatabase(dbName, DBService.connect(dbName));
        InitializationService.initializeTables(DBService.connect(dbName));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            if ("mainMenu" == appState.getCurrentLocation()) {
                CliMenuService.generateMainMenu();
            }


            System.out.println("\nEnter a selection: ");

            int selection = Integer.parseInt(scanner.nextLine());

        }






//        String filename = "expense.db";

//        SqliteConnect.createNewDatabase(filename);
        // Connection connection = SqliteConnect.connect(filename);
//         SqliteConnect.createNewTable(filename);

//        DBService dbService = new DBService();
//
//        dbService.insert(BigDecimal.valueOf(45.00), "Car wash", "Cash");
//        dbService.insert(BigDecimal.valueOf(1049.23), "New Computer", "Debit Card");
//        dbService.insert(BigDecimal.valueOf(23.45), "Water Bill", "Check");








//        AnsiConsole.systemInstall();
//
//        ExpenseService expenseService = new ExpenseService();
//
//        System.out.println(ansi().eraseScreen());
//        CliService.generateWelcomeHeader();
//
//        while (true) {
//            CliService.generateMainMenu();
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("\nEnter a selection: ");
//
//            int selection = Integer.parseInt(scanner.nextLine());
//
//            if (selection == 1) {
//                System.out.println("Enter an amount: ");
//                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
//                System.out.println("Enter a name: ");
//                String name = scanner.nextLine();
//                System.out.println("Enter a type: ");
//                String type = scanner.nextLine();
//
//                expenseService.addExpense(amount, name, type);
//                List<Expense> expenses = expenseService.getAllExpenses();
//
//                for (Expense expense:expenses) {
//                    System.out.println(expense);
//                }
//            } else if (selection == 6) {
//                System.out.println("\nGoodbye!\n");
//                System.exit(0);
//            } else {
//                throw new NumberFormatException("Entry is invalid. Please choose a value between 1 - 6.");
//                //System.out.println("Entry is invalid. Please choose a value between 1 - 6.");
//            }
//        }

    }



//    6public void insert(BigDecimal amount, String reference, String type) {
//        String sql = "INSERT INTO expenses(amount, reference, type) VALUE (?,?,?)";
//
//        try (connection; PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement(1, amount);
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}