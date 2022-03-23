package com.kevcode.springpractice.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kevcode.springpractice.domain.entities.base.DateTimeHelper;
import com.kevcode.springpractice.domain.entities.base.EntityBase;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Person extends EntityBase {

    @JsonIgnore
    @Transient
    private DateTimeHelper dateTimeHelper;
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    private int age;

    public Person(){
        dateTimeHelper = new DateTimeHelper();;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int calculateYearDiff(){
        return dateTimeHelper.calculateYearDiff(birthDate);
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
