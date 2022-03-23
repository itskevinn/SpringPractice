package com.kevcode.springpractice.api.config;

import com.kevcode.springpractice.domain.entities.base.DateTimeHelper;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringPracticeConfiguration {
    @Autowired
    private EntityManager entityManager;
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public DateTimeHelper dateTimeHelper(){return new DateTimeHelper();};
    @Autowired
    SessionFactory sessionFactory;
}
