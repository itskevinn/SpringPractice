package com.kevcode.springpractice.domain.repository;

import com.kevcode.springpractice.domain.entities.base.EntityBase;
import org.springframework.stereotype.Component;

public interface IUnitOfWork {
    void commit();
    void rollback();
    <T extends EntityBase, U> IGenericRepository<T,U> getRepositoryFor(Class<T> clazz);
}
