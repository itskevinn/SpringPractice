package com.kevcode.springpractice.api.controllers;


import com.kevcode.springpractice.application.customer.dto.CustomerDto;
import com.kevcode.springpractice.application.customer.request.CustomerRequest;
import com.kevcode.springpractice.application.customer.services.implementations.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService _customerService;

    @GetMapping("/Customers")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return _customerService.getAllCustomers();
    }

    @PostMapping("/Customers/Create")
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerRequest customer) {
        return _customerService.saveCustomer(customer);
    }

    @GetMapping("/Customers/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") Long id) {
        return _customerService.getCustomerById(id);
    }
}
