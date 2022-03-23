package com.kevcode.springpractice.domain.entities;

import com.kevcode.springpractice.domain.entities.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends EntityBase {


    private String subject;
    private String description;
@ManyToOne
private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
private Employee employee;
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
