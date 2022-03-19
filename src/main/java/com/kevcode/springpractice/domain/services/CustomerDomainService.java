package com.kevcode.springpractice.domain.services;

import com.kevcode.springpractice.domain.entities.Customer;
import com.kevcode.springpractice.domain.repository.IGenericRepository;
import com.kevcode.springpractice.domain.repository.IUnitOfWork;
import com.kevcode.springpractice.domain.services.base.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("DomainCustomerService")
public class CustomerDomainService implements IDomainService {
    @Autowired
    private IUnitOfWork unitOfWork;

    public CustomerDomainService(IUnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Autowired
    private final IGenericRepository<Customer, UUID> repository;

    {
        assert unitOfWork != null;
        repository = unitOfWork.getRepositoryFor(Customer.class);
    }

    public List<Customer> getAll()
    {
        return repository.getAll();
    }
}
