package com.berkay.account.service;

import com.berkay.account.dto.AccountDto;
import com.berkay.account.dto.AccoutDtoConverter;
import com.berkay.account.dto.CreateAccountRequest;
import com.berkay.account.model.Account;
import com.berkay.account.model.Transaction;
import com.berkay.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import com.berkay.account.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccoutDtoConverter converter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, TransactionService transactionService, AccoutDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

}
