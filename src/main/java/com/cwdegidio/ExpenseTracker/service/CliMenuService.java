package com.cwdegidio.ExpenseTracker.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.fusesource.jansi.Ansi.ansi;

public class CliMenuService {

    public static void generateWelcomeHeader() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

        System.out.println("\n\n=================================================================");
        System.out.println(ansi().render("@|cyan,bold Daily Expense Tracker |@"));
        System.out.println("Welcome! Today's date is " + ZonedDateTime.now().format(formatter));
        System.out.println("=================================================================\n");
    }

    public static void generateMainMenu() {
        System.out.println(ansi().render("\n @|magenta Main Menu |@"));
        System.out.println("-----------------------------------------------------------------");
        System.out.println(ansi().render("1. @|cyan Expenses |@"));
        System.out.println(ansi().render("2. @|cyan Transaction Categories |@"));
        System.out.println(ansi().render("3. @|cyan Payment Types |@"));
    }

    public static void generateTransactionMenu() {
        System.out.println(ansi().render("\n @|magenta Transaction Categories|@"));
        System.out.println("-----------------------------------------------------------------");
        System.out.println(ansi().render("1. @|cyan View all categories |@"));
        System.out.println(ansi().render("2. @|cyan Create new category |@"));
        System.out.println(ansi().render("3. @|cyan Update category |@"));
        System.out.println(ansi().render("4. @|cyan Delete category |@"));
    }
}
