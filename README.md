# JanielJavier_COMP303_Assignment4

This project implements a microservices-based architecture using Spring Boot. It consists of three microservices that work together to handle stock order placements, calculate fees, and manage account transactions.

---

## 🔧 Microservices Overview

### 1. Account Transactions Service
- **Purpose**: Manages account data and stock quantities.
- **Key Operations**:
  - **Create Account**: Allows the creation of a new account with an initial stock quantity and price.
  - **Reserve Stock**: Deducts (reserves) the requested quantity from the available stock when an order is placed.

---

### 2. Fee Service
- **Purpose**: Calculates transaction fees based on order details.
- **Key Operation**:
  - **Calculate Fee**: Computes a fee using a fixed percentage (e.g., 10%) from the order’s price and quantity.

---

### 3. Order Service
- **Purpose**: Acts as the orchestrator by handling order placement and integrating responses from the other two microservices.
- **Key Operation**:
  - **Place Order**:
    - Collects order details via a Thymeleaf UI or JSON (via Postman).
    - Calls the **Account Service** (using `RestTemplate`) to reserve stocks.
    - Updates order details with the account’s current stock price and remaining quantity.
    - Calls the **Fee Service** (again using `RestTemplate`) to calculate the transaction fee based on the updated price.

---

## 🔁 Inter-Service Communication

All communication between services is done using **REST API calls**.

- We use Spring’s `RestTemplate` to make HTTP requests to external endpoints.
- JSON responses from other microservices are automatically deserialized into Java objects using Spring Boot’s built-in HTTP message converters powered by **Jackson**.
- Example DTOs used:
  - `AccountResponseDTO`
  - `FeeResponseDTO`

This allows seamless transformation between JSON payloads and Java objects during inter-service communication.

---

