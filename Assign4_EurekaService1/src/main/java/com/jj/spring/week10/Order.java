package com.jj.spring.week10;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "orders")
//public class Order {
//    
//    @Id
//    private String id;
//    
//    private String accountNumber;
//    private String stockSymbol;
//    private int quantity;
//    private double price;
//    private String status; // e.g., "RESERVED" or "FAILED"
//    private double feeAmount; // New field to store fee details
//
//    public Order() { }
//
//    public Order(String accountNumber, String stockSymbol, int quantity, double price, String status, double feeAmount) {
//        this.accountNumber = accountNumber;
//        this.stockSymbol = stockSymbol;
//        this.quantity = quantity;
//        this.price = price;
//        this.status = status;
//        this.feeAmount = feeAmount;
//    }
//
//    // Getters and setters
//
//    public String getId() {
//        return id;
//    }
//
//    public String getAccountNumber() {
//        return accountNumber;
//    }
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public String getStockSymbol() {
//        return stockSymbol;
//    }
//    public void setStockSymbol(String stockSymbol) {
//        this.stockSymbol = stockSymbol;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public double getFeeAmount() {
//        return feeAmount;
//    }
//    public void setFeeAmount(double feeAmount) {
//        this.feeAmount = feeAmount;
//    }
//}


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    
    private String accountNumber;
    private String stockSymbol;
    
    // The quantity the user requested to reserve
    private int reservedQuantity;
    
    // Order processing status: e.g., "RESERVED" or "FAILED"
    private String status;
    
    // Calculated fee amount from FeeService
    private double feeAmount;
    
    // The remaining quantity in the account after the reservation
    private int remainingQuantity;
    
    // The price per stock as returned by the Account Service
    private double accountPrice;

    public Order() { }

    public Order(String accountNumber, String stockSymbol, int reservedQuantity, String status,
                 double feeAmount, int remainingQuantity, double accountPrice) {
        this.accountNumber = accountNumber;
        this.stockSymbol = stockSymbol;
        this.reservedQuantity = reservedQuantity;
        this.status = status;
        this.feeAmount = feeAmount;
        this.remainingQuantity = remainingQuantity;
        this.accountPrice = accountPrice;
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
    
    public int getReservedQuantity() {
        return reservedQuantity;
    }
    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getFeeAmount() {
        return feeAmount;
    }
    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }
    
    public int getRemainingQuantity() {
        return remainingQuantity;
    }
    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
    
    public double getAccountPrice() {
        return accountPrice;
    }
    public void setAccountPrice(double accountPrice) {
        this.accountPrice = accountPrice;
    }
}