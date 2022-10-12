package com.cwdegidio.ExpenseTracker.service;

import com.cwdegidio.ExpenseTracker.model.Expense;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVService {

    public static void writeExpenseToCsv(Expense expense) throws IOException {
        String userHomeDir = System.getProperty("user.home");
        String appDir = userHomeDir + "/.expense_tracker";

        File tmpDir = new File(appDir);
        boolean dirExists = tmpDir.isDirectory();

        if (!dirExists) {
            // TODO make path an changeable parameter in a properties file
            tmpDir.mkdirs();
            System.out.println("~/.expense_tracker has been created.");
        }

        String fileName = appDir + "/expenses.csv";
        File expenseFile = new File(fileName);
        boolean fileExists = expenseFile.exists();

        CSVWriter csvWriter;

        if (!fileExists) {
            csvWriter = new CSVWriter(new FileWriter(fileName));
            System.out.println("~/.expense_tracker/expenses.csv created");
        } else {
            csvWriter = new CSVWriter(new FileWriter(fileName, true));
        }

        csvWriter.writeNext(new String[]{"1", "David", "Male", "24"});
        csvWriter.close();


        System.out.println(expense);

    }
}
