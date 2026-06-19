package com.example.account_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")

public class Account {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String customerName;

	    @Column(unique = true)
	    private String accountNumber;

	    private Double balance;

	    // ✅ Getters & Setters

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
