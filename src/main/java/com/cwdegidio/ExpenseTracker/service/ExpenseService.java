package com.cwdegidio.ExpenseTracker.service;

import com.cwdegidio.ExpenseTracker.model.Expense;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    private static final List<Expense> expenses = new ArrayList<>();
    private int currentId = 0;

    public void addExpense(BigDecimal amount, String name, String type) {
        Expense expense = new Expense(getNextId(), amount, name, type);
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public int getNextId() {
        int nextId = currentId + 1;
        currentId = nextId;
        return nextId;
    }
}
