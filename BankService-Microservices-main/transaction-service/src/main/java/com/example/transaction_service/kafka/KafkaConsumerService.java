package com.example.transaction_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	  @KafkaListener(
	            topics = "bank-transactions",
	            groupId = "bank-group")
	    public void consume(String message) {

	        System.out.println("Received Event : " + message);

	    }

}
