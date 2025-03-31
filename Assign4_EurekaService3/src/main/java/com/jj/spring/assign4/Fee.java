package com.jj.spring.assign4;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fees")
public class Fee {

    @Id
    private String id;
    
    private String accountNumber;
    private String stockSymbol;
    private int quantity;
    private double price;
    private double feePercentage;
    private double feeAmount;

    public Fee() { }

    public Fee(String accountNumber, String stockSymbol, int quantity, double price, double feePercentage, double feeAmount) {
        this.accountNumber = accountNumber;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.feePercentage = feePercentage;
        this.feeAmount = feeAmount;
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

    public double getFeePercentage() {
        return feePercentage;
    }
    public void setFeePercentage(double feePercentage) {
        this.feePercentage = feePercentage;
    }

    public double getFeeAmount() {
        return feeAmount;
    }
    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }
}