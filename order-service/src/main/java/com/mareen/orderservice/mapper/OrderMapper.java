package com.mareen.orderservice.mapper;

import com.mareen.orderservice.dto.OrderRequest;
import com.mareen.orderservice.dto.OrderResponse;
import com.mareen.orderservice.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {


  public Order toOrder(OrderRequest request) {
    if (request == null) {
      return null;
    }
    return Order.builder()
        .id(request.id())
        .reference(request.reference())
        .paymentMethod(request.paymentMethod())
        .customerId(request.customerId())
        .build();
  }

  public OrderResponse fromOrder(Order order) {
    return new OrderResponse(
        order.getId(),
        order.getReference(),
        order.getTotalAmount(),
        order.getPaymentMethod(),
        order.getCustomerId()
    );
  }
}
