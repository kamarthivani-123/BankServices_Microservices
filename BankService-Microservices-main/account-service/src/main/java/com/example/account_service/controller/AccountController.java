package com.example.account_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account_service.dto.AccountRequest;
import com.example.account_service.dto.AccountResponse;
import com.example.account_service.service.AccountService;

@RestController
@RequestMapping("/accounts")  

public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public AccountResponse createAccount(@RequestBody AccountRequest request) {
        return service.createAccount(request);
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable Long id) {
        return service.getAccount(id);
    }

}
