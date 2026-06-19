package com.example.account_service.dto;

public class AccountResponse {

	  private Long id;
	    private String customerName;
	    private String accountNumber;
	    private Double balance;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public void setAccountNumber(String accountNumber) {
	        this.accountNumber = accountNumber;
	    }

	    public Double getBalance() {
	        return balance;
	    }

	    public void setBalance(Double balance) {
	        this.balance = balance;
	    }

}
