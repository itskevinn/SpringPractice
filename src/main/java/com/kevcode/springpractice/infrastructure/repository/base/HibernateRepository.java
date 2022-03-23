package com.kevcode.springpractice.infrastructure.repository.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(final SessionFactory session) {
        this.sessionFactory = session;
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }
}
