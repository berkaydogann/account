package com.berkay.account.service;

import com.berkay.account.dto.AccountDto;
import com.berkay.account.dto.CreateAccountRequest;
import com.berkay.account.model.Account;
import com.berkay.account.model.Transaction;
import com.berkay.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import com.berkay.account.model.Customer;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService<AccoutDtoConverter> {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccoutDtoConverter converter;
    private final Clock clock;


    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccoutDtoConverter converter,Clock clock) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
        this.clock = clock;

    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                getLocalDateTimeNow());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    getLocalDateTimeNow(),
                    account);

            account.getTransaction().add(transaction);
        }
        return converter(accountRepository.save(account));
    }

    private LocalDateTime getLocalDateTimeNow() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }

}
