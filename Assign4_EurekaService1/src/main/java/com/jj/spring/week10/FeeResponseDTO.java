package com.jj.spring.week10;

/*
Used by the Order Service to capture the response from the Fee Service.
After the Order Service calls the Fee Service (passing order details including the price obtained from the Account Service),
the fee calculation is returned as JSON and deserialized into a FeeResponseDTO. 
This object contains all relevant fee details such as fee percentage and calculated fee amount. 
The fee amount is then stored in the order record.
*/

public class FeeResponseDTO {

    private String id;
    private String accountNumber;
    private String stockSymbol;
    private int quantity; //The quantity used for fee calculation.
    private double price;
    private double feePercentage; //The percentage fee rate applied.
    private double feeAmount; //The calculated fee amount.

    public FeeResponseDTO() { }

    // Getters and setters

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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