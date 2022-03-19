package com.kevcode.springpractice.infrastructure.repository;

import com.kevcode.springpractice.domain.entities.base.EntityBase;
import com.kevcode.springpractice.domain.repository.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;


public class GenericRepository<T extends EntityBase, U extends UUID> implements IGenericRepository<T, U> {
    @Autowired
    private JpaRepository<T,U> jpaRepository;

    @Override
    public T save(T entity) {
        jpaRepository.save(entity);
        return entity;
    }

    @Override
    public List<T> getAll() {
       return jpaRepository.findAll();
    }

    @Override
    public T getById(U id) {
       return jpaRepository.getById(id);
    }

    @Override
    public List<T> getBy(Example<T> predicate) {
        return jpaRepository.findAll(predicate);
    }

    @Override
    public 	<S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return jpaRepository.findBy(example, queryFunction);
    }

    @Override
    public List<T> getBy(Sort sort) {
        return jpaRepository.findAll(sort);
    }

    @Override
    public List<T> getBy(Example<T> predicate, Sort sort) {
      return jpaRepository.findAll(predicate,sort);
    }


    @Override
    public void update(T entity, U id) {
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {
        jpaRepository.delete(entity);
    }

    @Override
    public void deleteRange(List<T> entities) {
        jpaRepository.deleteAll(entities);
    }

    @Override
    public List<T> getAllById(List<U> ids) {
        return jpaRepository.findAllById(ids);
    }
}
