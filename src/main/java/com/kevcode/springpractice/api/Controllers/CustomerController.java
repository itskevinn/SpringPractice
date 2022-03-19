package com.kevcode.springpractice.api.Controllers;


import com.kevcode.springpractice.application.customer.dto.CustomerDto;
import com.kevcode.springpractice.application.customer.services.CustomerService;
import com.kevcode.springpractice.infrastructure.repository.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService _customerService;
    @Autowired
    public CustomerController(UnitOfWork unitOfWork){
        _customerService = (CustomerService) unitOfWork.getAppService(CustomerService.class);
    }
    @GetMapping("/People")
    public List<CustomerDto> getAll(){
        return _customerService.getAllCustomers();
    }
}
