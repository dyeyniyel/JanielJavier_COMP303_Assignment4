package com.jj.spring.assign4;

//Used by the Account microservice to process a stock reservation request (stock validation and reduction)
public class AccountReserveRequestDTO {
    
    private String accountNumber;
    private String stockSymbol;
    private int quantity;  // The quantity to reserve (deduct)
    private double price;  // Price per stock 

    public AccountReserveRequestDTO() { }

    public AccountReserveRequestDTO(String accountNumber, String stockSymbol, int quantity, double price) {
        this.accountNumber = accountNumber;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters

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
