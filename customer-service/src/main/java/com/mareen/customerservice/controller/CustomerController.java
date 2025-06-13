package com.mareen.customerservice.controller;

import com.mareen.customerservice.dto.CustomerRequestDto;
import com.mareen.customerservice.dto.CustomerResponseDto;
import com.mareen.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerRequestDto));
    }
}
