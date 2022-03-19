package com.kevcode.springpractice.application.customer.services;

import com.kevcode.springpractice.application.base.IAppService;
import com.kevcode.springpractice.application.customer.dto.CustomerDto;
import com.kevcode.springpractice.domain.services.CustomerDomainService;
import com.kevcode.springpractice.infrastructure.repository.UnitOfWork;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationCustomerService")
public class CustomerService implements IAppService {
    private final CustomerDomainService _customerDomainService;
    public CustomerService(UnitOfWork unitOfWork){
        _customerDomainService = (CustomerDomainService) unitOfWork.getService(CustomerDomainService.class);
    }
    public List<CustomerDto> getAllCustomers(){

       return _customerDomainService.getAll();
    }
}
