package com.kevcode.springpractice.domain.repository;

import com.kevcode.springpractice.domain.entities.Employee;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

@NoRepositoryBean
public interface IEmployeeRepository {
    Employee save(Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);
}
