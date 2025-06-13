package com.mareen.orderservice.client.customer;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email
) {

}
