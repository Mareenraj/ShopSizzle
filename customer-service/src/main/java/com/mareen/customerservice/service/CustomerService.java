package com.mareen.customerservice.service;

import com.mareen.customerservice.dto.CustomerRequestDto;
import com.mareen.customerservice.dto.CustomerResponseDto;
import com.mareen.customerservice.entity.Customer;
import com.mareen.customerservice.exception.CustomerNotFoundException;
import com.mareen.customerservice.exception.EmailAlreadyExistsException;
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
        if (customerRepository.existsByEmail(customerRequestDto.email())) {
            throw new EmailAlreadyExistsException("This email is already used!");
        }
        customerRepository.save(customerMapper.toCustomer(customerRequestDto));
        return "Customer created successfully";
    }

    public String updateCustomer(Long id, CustomerRequestDto customerRequestDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        customer.setFirstName(customerRequestDto.firstName());
        customer.setLastName(customerRequestDto.lastName());
        customer.setEmail(customerRequestDto.email());
        customer.setAddresses(customerMapper.toAddresses(customerRequestDto.addressRequestDtoSet()));
        customerRepository.save(customer);
        return "Customer updated successfully";
    }

    public CustomerResponseDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        return customerMapper.toCustomerResponseDto(customer);
    }
}
