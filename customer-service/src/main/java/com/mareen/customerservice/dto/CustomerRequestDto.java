package com.mareen.customerservice.dto;

import com.mareen.customerservice.entity.Address;

public record CustomerRequestDto(
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
