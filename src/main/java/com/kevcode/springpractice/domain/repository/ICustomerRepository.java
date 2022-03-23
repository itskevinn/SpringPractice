package com.kevcode.springpractice.domain.repository;

import com.kevcode.springpractice.domain.entities.Customer;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.function.Predicate;

@NoRepositoryBean
public interface ICustomerRepository {
    Customer save(Customer entity);

    List<Customer> getAll();

    Customer findById(Long id);

    List<Customer> getBy(Predicate<Customer> predicate);

    void update(Customer entity);

    void delete(Customer entity);

    void deleteRange(List<Customer> entities);

    List<Customer> getAllById(List<Long> ids);
}
