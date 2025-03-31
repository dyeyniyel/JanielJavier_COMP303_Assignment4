package com.jj.spring.assign4;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
    // Optional custom query method if needed for future integration.
    Mono<Account> findByAccountNumberAndStockSymbol(String accountNumber, String stockSymbol);
}