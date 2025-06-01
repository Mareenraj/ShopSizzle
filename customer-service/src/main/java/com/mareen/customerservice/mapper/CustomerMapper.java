package com.mareen.customerservice.mapper;

import com.mareen.customerservice.dto.AddressRequestDto;
import com.mareen.customerservice.dto.CustomerRequestDto;
import com.mareen.customerservice.entity.Address;
import com.mareen.customerservice.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .firstName(customerRequestDto.firstName())
                .lastName(customerRequestDto.lastName())
                .email(customerRequestDto.email())
                .addresses(customerRequestDto.addressRequestDtoSet().stream().map(this::toAddress).collect(Collectors.toSet()))
                .build();
    }

    private Address toAddress(AddressRequestDto addressRequestDto) {
        return Address.builder()
                .houseNumber(addressRequestDto.houseNumber())
                .street(addressRequestDto.street())
                .zipCode(addressRequestDto.zipCode())
                .build();
    }
}
