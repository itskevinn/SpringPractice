package com.kevcode.springpractice.infrastructure.repository;

import com.kevcode.springpractice.domain.entities.Employee;
import com.kevcode.springpractice.domain.repository.IEmployeeRepository;
import com.kevcode.springpractice.infrastructure.repository.base.HibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeHibernateRepository extends HibernateRepository implements IEmployeeRepository {

    @Override
    public Employee save(Employee employee) {
        this.getSession().save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return this.getSession().createQuery("from Employee").list();
    }

    @Override
    public Employee getById(Long id) {
        return (Employee) this.getSession().byId(String.valueOf(id));
    }
}
