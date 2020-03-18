package com.example.LoginRegisterAPI.services;

import com.example.LoginRegisterAPI.entities.Account;
import com.example.LoginRegisterAPI.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> findAccount(String username) {
        return accountRepository.findByUsername(username);
    }
}