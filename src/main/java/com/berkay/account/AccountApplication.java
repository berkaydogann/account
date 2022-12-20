package com.berkay.account;

import com.berkay.account.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
