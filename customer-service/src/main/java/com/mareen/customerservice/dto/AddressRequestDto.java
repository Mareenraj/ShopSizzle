package com.mareen.customerservice.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressRequestDto(
        @NotBlank
        String street,
        @NotBlank
        String houseNumber,
        @NotBlank
        String zipCode
) {
}
