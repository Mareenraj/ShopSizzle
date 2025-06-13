package com.mareen.customerservice.dto;

import lombok.Builder;

@Builder
public record AddressResponseDto(
        Long id,
        String street,
        String houseNumber,
        String zipCode
) {
}
