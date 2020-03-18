package com.example.LoginRegisterAPI.controllers;

import com.example.LoginRegisterAPI.entities.Account;
import com.example.LoginRegisterAPI.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        Optional<Account> check = accountService.findAccount(account.getUsername());
        if (!check.isPresent()) {
            accountService.addAccount(account);
            return new ResponseEntity<>("Successfully Registered", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> findAccount(@RequestBody Account account) {
        Optional<Account> user = accountService.findAccount(account.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(account.getPassword())) {
            return new ResponseEntity<>("Login Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
        }
    }
}
