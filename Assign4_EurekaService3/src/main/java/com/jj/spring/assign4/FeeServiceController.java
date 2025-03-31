package com.jj.spring.assign4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fees")
public class FeeServiceController {

    @Autowired
    private FeeService feeService;

    /**
     * Calculate fee endpoint
     * {
     *   "accountNumber": "ACC123",
     *   "stockSymbol": "AAPL",
     *   "quantity": 50,
     *   "price": 145.67
     * }
     *
     * Returns the Fee object with feePercentage and feeAmount calculated.
     */
    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Fee> calculateFee(@RequestBody Fee feeRequest) {
        return feeService.calculateFee(
                feeRequest.getAccountNumber(),
                feeRequest.getStockSymbol(),
                feeRequest.getQuantity(),
                feeRequest.getPrice()
        );
    }
    
    /**
     * Custom status endpoint to show that AccountService is up.
     */
    @GetMapping("/status")
    public String status() {
        return "FeeService is up and running";
    }
}
