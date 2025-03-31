package com.jj.spring.week10;

//used by the Order Service to pass order details


public class OrderReserveRequestDTO {
    
    private String accountNumber;
    private String stockSymbol;
    // Quantity to reserve.
    private int quantity;
    // Price per stock. Although not entered by the user, this field will be set from the Account Service response.
    private double price;

    public OrderReserveRequestDTO() { }

    public OrderReserveRequestDTO(String accountNumber, String stockSymbol, int quantity, double price) {
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

