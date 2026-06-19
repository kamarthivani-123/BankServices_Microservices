package com.example.account_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.account_service.entity.Account;

public interface AccountRepository  extends JpaRepository<Account, Long> {
	Optional<Account> findByAccountNumber(String accountNumber);
}
