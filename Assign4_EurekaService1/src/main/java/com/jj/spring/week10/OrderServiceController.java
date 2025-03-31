package com.jj.spring.week10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
public class OrderServiceController {

    @Autowired
    private OrderService orderService;

    /**
     * GET endpoint to display the order form (Thymeleaf UI)
     * Adds an empty OrderReserveRequestDTO to the model to bind form fields
     */
    @GetMapping("/order")
    public Mono<String> showOrderForm(Model model) {
         model.addAttribute("order", new OrderReserveRequestDTO());
         return Mono.just("orderForm");  //Returns orderForm.html
    }

    /**
     * POST endpoint to process the order from the Thymeleaf form
     * Binds the form data to an OrderReserveRequestDTO and passes it to the OrderService
     */
    @PostMapping("/order/place")
    public Mono<String> placeOrder(@ModelAttribute("order") OrderReserveRequestDTO orderReserveRequestDTO, Model model) {
         return orderService.placeOrder(orderReserveRequestDTO)
            .map(savedOrder -> {
                model.addAttribute("message", "Order placed successfully with status: " + savedOrder.getStatus());
                model.addAttribute("order", savedOrder);
                return "orderConfirmation"; //Returns orderConfirmation.html
            })
            .onErrorResume(e -> {
                model.addAttribute("error", e.getMessage());
                return Mono.just("orderForm"); // Redisplay the form with error message
            });
    }

    
    /**
     * REST endpoint to process the order via JSON.
     * Use this endpoint in Postman.
     *
     * URL: http://localhost:8080/api/order/place
     * {
     *    "accountNumber": "ABC123",
     *    "stockSymbol": "AAA",
     *    "quantity": 50,
     *    "price": 149.99
     * }
     * 
     */

    
    /* placeOrderJson method exposes a REST endpoint at /api/order/place that accepts and returns JSON.
    The @RequestBody annotation tells Spring to convert the incoming JSON into an OrderReserveRequestDTO object.
    The method returns the saved Order wrapped in a ResponseEntity.
     */
    
    @PostMapping(value="/api/order/place", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<Order>> placeOrderJson(@RequestBody OrderReserveRequestDTO orderReserveRequestDTO) {
         return orderService.placeOrder(orderReserveRequestDTO)
            .map(order -> ResponseEntity.ok(order))
            .onErrorResume(e ->
                Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null))
            );
    }
}
