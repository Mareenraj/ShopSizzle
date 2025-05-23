package com.mareen.customerservice.controller;

import com.mareen.customerservice.dto.CustomerRequestDto;
import com.mareen.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDto));
    }

//    public ResponseEntity<String> updateCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
//        return ResponseEntity.ok(customerService.updateCustomer(customerRequestDto));
//    }
}
