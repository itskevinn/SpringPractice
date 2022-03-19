package com.kevcode.springpractice.domain.entities;

import com.kevcode.springpractice.domain.entities.base.EntityBase;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity

public abstract class Person extends EntityBase {
    private String name;
    private String lastName;
    private Date birthDate;

    private int age;

    public int getAge(){
        LocalDate birthDateLocal = LocalDate.parse(getBirthDate().toString());
        Period period = Period.between(birthDateLocal, LocalDate.now());
        return period.getYears();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
