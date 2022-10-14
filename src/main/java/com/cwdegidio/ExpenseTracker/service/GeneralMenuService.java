package com.cwdegidio.ExpenseTracker.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class GeneralMenuService {

    private static final HashMap<Integer, String> currentMenuOptions = new HashMap<>();
    private static Integer userChoice = 0;

    public static void generateHeader() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("=================================================================");
        System.out.println(ansi().render("\s@|cyan,bold Daily Expense Tracker |@"));
        System.out.println("\sToday's date is " + ZonedDateTime.now().format(formatter));
        System.out.println("=================================================================\n");
    }

    public static String generateMainMenu(Scanner scanner) {
        generateHeader();

        currentMenuOptions.clear();
        currentMenuOptions.put(1, "expenses");
        currentMenuOptions.put(2, "categories");
        currentMenuOptions.put(3, "types");

        System.out.println(ansi().render("\n @|magenta Main Menu |@"));
        System.out.println("-----------------------------------------------------------------");
        System.out.println(ansi().render("1. @|cyan Expenses |@"));
        System.out.println(ansi().render("2. @|cyan Transaction Categories |@"));
        System.out.println(ansi().render("3. @|cyan Payment Types |@"));

        System.out.println("\nEnter a selection: ");

        userChoice = Integer.parseInt(scanner.nextLine());

        return currentMenuOptions.get(userChoice);
    }


    // Transaction Categories

}
