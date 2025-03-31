package com.jj.spring.week10;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    //Hardcoded URLs for external microservices
    private final String accountServiceUrl = "http://localhost:9091/accounts/reserve"; //Account Service for stock reservation
    private final String feeServiceUrl = "http://localhost:9092/fees/calculate"; //Fee Service for fee calculation

    
    //RestTemplate to make REST calls.
    private final RestTemplate restTemplate = new RestTemplate();
    
    //Repository for saving Order objects
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Places an order by:
     *   1. Calling the Account Service to reserve stock
     *   2. Using the account price from the Account Service to call Fee Service
     *   3. Saving the order (including fee, remaining quantity, and account price)
     *      using ReactiveMongoRepository
     *
     */
    
    //     * @param orderReserveRequestDTO contains order details (account number, stock symbol, quantity, and price)
    public Mono<Order> placeOrder(OrderReserveRequestDTO orderReserveRequestDTO) {
        HttpHeaders headers = new HttpHeaders();   //Create HTTP headers and set content type to JSON
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Variable to store response body from the Account Service
        AccountResponseDTO accountResponseBody = null;
        try {
            //Create request entity for the Account Service using the order DTO
            HttpEntity<OrderReserveRequestDTO> accountRequestEntity = new HttpEntity<>(orderReserveRequestDTO, headers);
            
            //Make a REST POST call to reserve stock
            ResponseEntity<AccountResponseDTO> accountResponse = restTemplate.postForEntity(
                    accountServiceUrl, accountRequestEntity, AccountResponseDTO.class);
            
            //Retrieve the response body containing updated account details
            accountResponseBody = accountResponse.getBody();
        } catch (HttpClientErrorException ex) {
            // Catch 400 errors (invalid account number/stock symbol) and return a friendly error
            return Mono.error(new RuntimeException("Invalid account number or stock symbol. Please try again."));
        }

        // Determine order status and extract account details.
        String orderStatus = (accountResponseBody != null) ? "RESERVED" : "FAILED";
        int remainingQuantity = (accountResponseBody != null) ? accountResponseBody.getQuantity() : 0;
        double accountPrice = (accountResponseBody != null) ? accountResponseBody.getPrice() : 0.0;

        //Update the order DTO with the price received from the Account Service
        orderReserveRequestDTO.setPrice(accountPrice);

        //Variable to store response body from the Fee Service
        FeeResponseDTO feeResponseBody = null;
        try {
        	//Create request entity for the Fee Service using the updated order DTO
            HttpEntity<OrderReserveRequestDTO> feeRequestEntity = new HttpEntity<>(orderReserveRequestDTO, headers);
            
            
            //Make a REST POST call to calculate fees
            ResponseEntity<FeeResponseDTO> feeResponse = restTemplate.postForEntity(
                    feeServiceUrl, feeRequestEntity, FeeResponseDTO.class);
            feeResponseBody = feeResponse.getBody();      //Retrieve the fee calculation response
        } catch (HttpClientErrorException ex) {
            // If fee service fails, we simply set fee to 0
            feeResponseBody = null;
        }

        //Extract the fee amount from the Fee Service response
        double feeAmount = (feeResponseBody != null) ? feeResponseBody.getFeeAmount() : 0.0;

        //Create the Order record with all the collected information
        Order order = new Order(
                orderReserveRequestDTO.getAccountNumber(),
                orderReserveRequestDTO.getStockSymbol(),
                orderReserveRequestDTO.getQuantity(), // reserved quantity
                orderStatus,
                feeAmount,
                remainingQuantity,
                accountPrice
        );

        //save the Order record using ReactiveMongoRepository and return the result as a Mono
        return orderRepository.save(order);
    }
}


