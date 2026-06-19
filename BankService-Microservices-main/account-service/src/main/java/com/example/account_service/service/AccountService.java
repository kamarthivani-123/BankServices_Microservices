package com.example.account_service.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.account_service.dto.AccountRequest;
import com.example.account_service.dto.AccountResponse;
import com.example.account_service.entity.Account;
import com.example.account_service.Repository.AccountRepository;

import com.example.account_service.Repository.AccountRepository;

@Service
public class AccountService {
	
private final AccountRepository repository;
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }
    public AccountResponse createAccount(AccountRequest request) {

        Account account = new Account();
        account.setCustomerName(request.getCustomerName());
        account.setAccountNumber(request.getAccountNumber());
        account.setBalance(request.getBalance());
        Account saved = repository.save(account);
    return mapToResponse(saved);
    }
    @Cacheable(value = "accounts", key = "#id")
    public AccountResponse getAccount(Long id) {

        Account account = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return mapToResponse(account);
    }
    public Double getBalance(Long id) {

        Account account = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return account.getBalance();
    }
private AccountResponse mapToResponse(Account account) {

    AccountResponse response = new AccountResponse();

    response.setId(account.getId());
    response.setCustomerName(account.getCustomerName());
    response.setAccountNumber(account.getAccountNumber());
    response.setBalance(account.getBalance());

    return response;
}


}
