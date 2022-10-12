package com.cwdegidio.ExpenseTracker.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.fusesource.jansi.Ansi.ansi;

public class CliService {

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
        System.out.println(ansi().render("1. @|cyan Add new expense |@"));
        System.out.println(ansi().render("2. @|cyan View all expenses |@"));
        System.out.println(ansi().render("3. @|cyan View single expense |@"));
        System.out.println(ansi().render("4. @|cyan Remove single expense |@"));
        System.out.println(ansi().render("5. @|cyan Remove all expenses |@"));
        System.out.println(ansi().render("6. @|cyan Exit application |@"));
    }

    public static void addExpenseDialogue() {

    }
}
