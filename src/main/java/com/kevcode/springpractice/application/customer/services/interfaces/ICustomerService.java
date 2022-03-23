package com.kevcode.springpractice.application.customer.services.interfaces;

import com.kevcode.springpractice.application.customer.dto.CustomerDto;
import com.kevcode.springpractice.application.customer.request.CustomerRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICustomerService {
    ResponseEntity<List<CustomerDto>> getAllCustomers();

    ResponseEntity<CustomerDto> saveCustomer(CustomerRequest customerRequest);

    ResponseEntity<CustomerDto> getCustomerById(Long id);
}
