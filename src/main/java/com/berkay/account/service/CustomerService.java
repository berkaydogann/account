package com.berkay.account.service;

import com.berkay.account.dto.CustomerDto;
import com.berkay.account.dto.CustomerDtoConverter;
import com.berkay.account.exception.CustomerNotFoundException;
import com.berkay.account.model.Customer;
import com.berkay.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));

    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }

    public Iterable<CustomerDto> getAllCustomer() {

        return customerRepository.findAll()
                .stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
