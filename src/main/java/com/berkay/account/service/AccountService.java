package com.berkay.account.service;

import com.berkay.account.dto.AccountDto;
import com.berkay.account.dto.CreateAccountRequest;
import com.berkay.account.model.Account;
import com.berkay.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import com.berkay.account.model.Customer;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }


}
