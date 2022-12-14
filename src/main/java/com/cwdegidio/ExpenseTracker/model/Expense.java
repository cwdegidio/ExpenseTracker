package com.cwdegidio.ExpenseTracker.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Expense {

    private int id;

    private BigDecimal amount;

    private String reference;

    private String category;

    private String type;

    private ZonedDateTime date;

    public Expense(int id, BigDecimal amount, String name, String type, String category) {
        this.id = id;
        this.amount = amount;
        this.reference = name;
        this.type = type;
        this.category = category;
        this.date = ZonedDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", name='" + reference + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                '}';
    }
}
