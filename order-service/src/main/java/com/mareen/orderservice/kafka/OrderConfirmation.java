package com.mareen.orderservice.kafka;

import com.mareen.orderservice.client.customer.CustomerResponse;
import com.mareen.orderservice.client.product.PurchaseResponse;
import com.mareen.orderservice.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
