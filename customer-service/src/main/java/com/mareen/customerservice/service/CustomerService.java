package com.mareen.customerservice.service;

import com.mareen.customerservice.dto.CustomerRequestDto;
import com.mareen.customerservice.mapper.CustomerMapper;
import com.mareen.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(@Valid CustomerRequestDto customerRequestDto) {
        customerRepository.save(customerMapper.toCustomer(customerRequestDto));
        return "customer created successfully";
    }

}
