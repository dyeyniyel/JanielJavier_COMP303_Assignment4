package com.jj.spring.assign4;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Reserves stock by reducing the available quantity in the account.
     * 
     */
    public Mono<Account> reserveStock(String accountNumber, String stockSymbol, int reserveQuantity, double price) {
        return accountRepository.findByAccountNumberAndStockSymbol(accountNumber, stockSymbol)
            .flatMap(account -> {
                if (account.getQuantity() < reserveQuantity) {
                    return Mono.error(new RuntimeException("Not enough stock available. Available: " + account.getQuantity()));
                }
                // Deduct the reserved quantity
                account.setQuantity(account.getQuantity() - reserveQuantity);
                return accountRepository.save(account);
            })
            .switchIfEmpty(Mono.error(new RuntimeException("Account not found for accountNumber: " + accountNumber + " and stockSymbol: " + stockSymbol)));
    }
    
    /**
     * Creates a new account record.
     */
    public Mono<Account> createAccount(Account account) {
        return accountRepository.save(account);
    }
}
