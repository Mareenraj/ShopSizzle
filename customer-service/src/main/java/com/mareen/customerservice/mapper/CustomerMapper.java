package com.mareen.customerservice.mapper;

import com.mareen.customerservice.dto.AddressRequestDto;
import com.mareen.customerservice.dto.AddressResponseDto;
import com.mareen.customerservice.dto.CustomerRequestDto;
import com.mareen.customerservice.dto.CustomerResponseDto;
import com.mareen.customerservice.entity.Address;
import com.mareen.customerservice.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .firstName(customerRequestDto.firstName())
                .lastName(customerRequestDto.lastName())
                .email(customerRequestDto.email())
                .addresses(toAddresses(customerRequestDto.addressRequestDtoSet()))
                .build();
    }

    public Set<Address> toAddresses(Set<AddressRequestDto> addressRequestDtoSet) {
        return addressRequestDtoSet.stream().map(addressRequestDto ->
                Address.builder()
                        .houseNumber(addressRequestDto.houseNumber())
                        .street(addressRequestDto.street())
                        .zipCode(addressRequestDto.zipCode())
                        .build()
        ).collect(Collectors.toSet());
    }

    public CustomerResponseDto toCustomerResponseDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .addressResponseDtoSet(toaddressResponseDtoSet(customer.getAddresses()))
                .build();
    }

    public Set<AddressResponseDto> toaddressResponseDtoSet(Set<Address> addresses) {
        return addresses.stream().map(address ->
                AddressResponseDto.builder()
                        .id(address.getId())
                        .houseNumber(address.getHouseNumber())
                        .street(address.getStreet())
                        .zipCode(address.getZipCode())
                        .build()
        ).collect(Collectors.toSet());
    }
}
