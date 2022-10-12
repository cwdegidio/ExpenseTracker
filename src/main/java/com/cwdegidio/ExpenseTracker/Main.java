package com.cwdegidio.ExpenseTracker;

import com.cwdegidio.ExpenseTracker.model.Expense;
import com.cwdegidio.ExpenseTracker.service.CSVService;
import com.cwdegidio.ExpenseTracker.service.CliService;
import com.cwdegidio.ExpenseTracker.service.ExpenseService;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;


public class Main {
    public static void main(String[] args) throws IOException {

        AnsiConsole.systemInstall();

        ExpenseService expenseService = new ExpenseService();

        System.out.println(ansi().eraseScreen());
        CliService.generateWelcomeHeader();

        while (true) {
            CliService.generateMainMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter a selection: ");

            int selection = Integer.parseInt(scanner.nextLine());

            if (selection == 1) {
                System.out.println("Enter an amount: ");
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                System.out.println("Enter a name: ");
                String name = scanner.nextLine();
                System.out.println("Enter a type: ");
                String type = scanner.nextLine();

                expenseService.addExpense(amount, name, type);
                List<Expense> expenses = expenseService.getAllExpenses();

                CSVService.writeExpenseToCsv(expenses.get(expenses.size() - 1));

//                for (Expense expense:expenses) {
//                    System.out.println(expense);
//                }
            } else if (selection == 6) {
                System.out.println("\nGoodbye!\n");
                System.exit(0);
            } else {
                throw new NumberFormatException("Entry is invalid. Please choose a value between 1 - 6.");
                //System.out.println("Entry is invalid. Please choose a value between 1 - 6.");
            }
        }

    }
}