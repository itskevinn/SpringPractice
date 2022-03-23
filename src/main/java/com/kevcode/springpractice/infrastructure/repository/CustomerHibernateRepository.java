package com.kevcode.springpractice.infrastructure.repository;

import com.kevcode.springpractice.domain.entities.Customer;
import com.kevcode.springpractice.domain.repository.ICustomerRepository;
import com.kevcode.springpractice.infrastructure.repository.base.HibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class CustomerHibernateRepository extends HibernateRepository implements ICustomerRepository {


    @Override
    public Customer save(Customer customer) {
        this.getSession().save(customer);
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return this.getSession().createQuery("from Customer").list();
    }

    @Override
    public Customer findById(Long id) {
        return (Customer) this.getSession().byId(String.valueOf(id));
    }

    @Override
    public List<Customer> getBy(Predicate<Customer> predicate) {
        List<Customer> customers = this.getSession().createQuery("from Customer").list();
        customers = customers.stream().filter(predicate).collect(Collectors.toList());
        return customers;
    }


    @Override
    public void update(Customer customer) {
        this.getSession().update(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.getSession().delete(customer);
    }

    @Override
    public void deleteRange(List<Customer> customers) {
        try {
            for (Customer customer : customers) {
                this.getSession().delete(customer);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Customer> getAllById(List<Long> ids) {
        return this.getSession().byMultipleIds(String.valueOf(ids)).multiLoad(ids);
    }

}
