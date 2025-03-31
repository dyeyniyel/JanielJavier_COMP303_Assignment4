package com.jj.spring.assign4;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents an account record with available stock.
 */
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;
    
    private String accountNumber;
    private String stockSymbol;
    private int quantity; // Available stock quantity
    private double price; // Price per stock (if needed)

    public Account() { }

    public Account(String accountNumber, String stockSymbol, int quantity, double price) {
        this.accountNumber = accountNumber;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
