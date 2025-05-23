package com.mareen.customerservice.mapper;

import com.mareen.customerservice.dto.CustomerRequestDto;
import com.mareen.customerservice.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .firstName(customerRequestDto.firstName())
                .lastName(customerRequestDto.lastName())
                .email(customerRequestDto.email())
                .address(customerRequestDto.address())
                .build();
    }
}
