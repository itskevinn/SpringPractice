package com.kevcode.springpractice.domain.entities;

import com.kevcode.springpractice.domain.entities.base.EntityBase;

import javax.persistence.Entity;

@Entity
public class Ticket extends EntityBase {
    private String subject;
    private String description;

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
