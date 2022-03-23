package com.kevcode.springpractice.application.customer.services.implementations;

import com.kevcode.springpractice.application.customer.dto.CustomerDto;
import com.kevcode.springpractice.application.customer.request.CustomerRequest;
import com.kevcode.springpractice.application.customer.services.interfaces.ICustomerService;
import com.kevcode.springpractice.domain.entities.Customer;
import com.kevcode.springpractice.infrastructure.repository.CustomerHibernateRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationCustomerService")
public class CustomerService implements ICustomerService {
    @Autowired
    private ModelMapper _modelMapper;
    @Autowired
    private CustomerHibernateRepository _customerHibernateRepository;

    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        try {
            List<Customer> customers = _customerHibernateRepository.getAll();
            final List<CustomerDto> customerDtos = _modelMapper.map(customers, new TypeToken<List<Customer>>() {
            }.getType());
            return new ResponseEntity<>(customerDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CustomerDto> saveCustomer(CustomerRequest customerRequest) {
        try {
            Customer customer = _modelMapper.map(customerRequest, Customer.class);
            customer.setAge(customer.calculateYearDiff());
            customer = _customerHibernateRepository.save(customer);
            CustomerDto customerDto = _modelMapper.map(customer, CustomerDto.class);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CustomerDto> getCustomerById(Long id) {
        try {
            Customer customer = _customerHibernateRepository.findById(id);
            if (customer == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            CustomerDto customerDto = _modelMapper.map(customer, CustomerDto.class);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
