package com.jj.spring.assign4;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FeeService {

    private final FeeRepository feeRepository;
    
    // Fixed fee percentage - 10%
    private final double DEFAULT_FEE_PERCENTAGE = 0.1;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    /**
     * Calculates fee based on the provided order details.
     *
     */
    public Mono<Fee> calculateFee(String accountNumber, String stockSymbol, int quantity, double price) {
        double feeAmount = price * quantity * DEFAULT_FEE_PERCENTAGE;
        Fee fee = new Fee(accountNumber, stockSymbol, quantity, price, DEFAULT_FEE_PERCENTAGE, feeAmount);
        return feeRepository.save(fee);
    }
}
