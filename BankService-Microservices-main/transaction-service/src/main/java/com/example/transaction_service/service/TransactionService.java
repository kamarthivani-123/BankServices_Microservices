package com.example.transaction_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transaction_service.dto.TransactionRequest;
import com.example.transaction_service.dto.TransactionResponse;
import com.example.transaction_service.entity.Transaction;
import com.example.transaction_service.kafka.KafkaProducerService;
import com.example.transaction_service.repository.TransactionRepository;
@Service
public class TransactionService {

 
	@Autowired
    private final TransactionRepository repository;
	
    @Autowired
	private KafkaProducerService producer
	;
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }
    // ✅ Transfer Money
    public TransactionResponse transferMoney(TransactionRequest request) {

        try {

            producer.publish("TRANSFER_INITIATED");

            Transaction txn = new Transaction();

            txn.setFromAccount(request.getFromAccount());
            txn.setToAccount(request.getToAccount());
            txn.setAmount(request.getAmount());

            producer.publish("AMOUNT_DEBITED");

            txn.setStatus("SUCCESS");

            Transaction saved = repository.save(txn);

            producer.publish("AMOUNT_CREDITED");

            return mapToResponse(saved);

        } catch (Exception e) {

            producer.publish("TRANSFER_FAILED");

            producer.publish("TRANSFER_COMPENSATED");

            throw e;
        }
    }
    // ✅ Mapping method
    private TransactionResponse mapToResponse(Transaction txn) {

        TransactionResponse res = new TransactionResponse();

        res.setId(txn.getId());
        res.setFromAccount(txn.getFromAccount());
        res.setToAccount(txn.getToAccount());
        res.setAmount(txn.getAmount());
        res.setStatus(txn.getStatus());
        res.setCreatedAt(txn.getCreatedAt());

        return res;
    }
	}


