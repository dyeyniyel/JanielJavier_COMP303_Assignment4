package com.jj.spring.assign4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {

    @Autowired
    private AccountService accountService;

    /**
     * Endpoint to reserve stock.
     * {
     *   "accountNumber": "ACC123",
     *   "stockSymbol": "AAPL",
     *   "quantity": 10,
     *   "price": 145.67
     * }
     *
     * The method reduces the available stock by the specified quantity.
     */
    @PostMapping("/reserve")
    public Mono<ResponseEntity<Account>> reserveStock(@RequestBody AccountReserveRequestDTO request) {
        return accountService.reserveStock(
            request.getAccountNumber(),
            request.getStockSymbol(),
            request.getQuantity(),
            request.getPrice()
        )
        .map(updatedAccount -> ResponseEntity.ok(updatedAccount))
        .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }
    
    @PostMapping("/create")
    public Mono<ResponseEntity<Account>> createAccount(@RequestBody Account account) {
        return accountService.createAccount(account)
            .map(savedAccount -> ResponseEntity.ok(savedAccount))
            .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }
    
    
    /**
     * Custom status endpoint to show that AccountService is up.
     */
    @GetMapping("/status")
    public String status() {
        return "AccountService is up and running";
    }
}
