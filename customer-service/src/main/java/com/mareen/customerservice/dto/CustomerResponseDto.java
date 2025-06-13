package com.mareen.customerservice.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record CustomerResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        Set<AddressResponseDto> addressResponseDtoSet
) {
}
