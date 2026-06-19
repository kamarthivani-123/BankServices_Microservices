package com.example.transaction_service.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transaction_service.dto.TransactionRequest;
import com.example.transaction_service.dto.TransactionResponse;
import com.example.transaction_service.service.TransactionService;


@RestController
@RequestMapping("/transactions")

public class TransactionController {

private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // ✅ Transfer Money
    @PostMapping("/transfer")
    public TransactionResponse transfer(@RequestBody TransactionRequest request) {
        return service.transferMoney(request);
    }

}
