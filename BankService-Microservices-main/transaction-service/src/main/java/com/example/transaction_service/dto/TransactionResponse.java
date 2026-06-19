package com.example.transaction_service.dto;

import java.time.LocalDateTime;

public class TransactionResponse {

	 private Long id;
	    private String fromAccount;
	    private String toAccount;
	    private Double amount;
	    private String status;
	    private LocalDateTime createdAt;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getFromAccount() {
	        return fromAccount;
	    }

	    public void setFromAccount(String fromAccount) {
	        this.fromAccount = fromAccount;
	    }

	    public String getToAccount() {
	        return toAccount;
	    }

	    public void setToAccount(String toAccount) {
	        this.toAccount = toAccount;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }

}
