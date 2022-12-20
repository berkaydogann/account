package com.berkay.account.repository;

import com.berkay.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscationRepository extends JpaRepository<Transaction,String> {
}
