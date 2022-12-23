package com.berkay.account.controller;

import com.berkay.account.dto.AccountDto;
import com.berkay.account.dto.CreateAccountRequest;
import com.berkay.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}
