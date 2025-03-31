package com.jj.spring.week10;

//This DTO is used by the Order Service to capture the response from the Account Service. 
//When the Order Service calls the Account Service to reserve stock, the response (in JSON format) is automatically deserialized into an instance of AccountResponseDTO.
//It provides the account number, stock symbol, the updated (remaining) quantity, and the stock price. These details are then used to update the order record.


public class AccountResponseDTO {

    private String accountNumber;
    private String stockSymbol;
    // Remaining quantity after reservation.
    private int quantity;
    // Price per stock as stored in the account.
    private double price;

    public AccountResponseDTO() { }

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
