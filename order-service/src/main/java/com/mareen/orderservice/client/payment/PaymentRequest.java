package com.mareen.orderservice.client.payment;

import com.mareen.orderservice.client.customer.CustomerResponse;
import com.mareen.orderservice.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
