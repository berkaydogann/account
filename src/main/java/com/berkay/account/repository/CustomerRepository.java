package com.berkay.account.repository;

import com.berkay.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends JpaRepository<Customer, String> {

}
