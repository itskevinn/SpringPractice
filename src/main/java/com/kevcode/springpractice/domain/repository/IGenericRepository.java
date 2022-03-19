package com.kevcode.springpractice.domain.repository;

import com.kevcode.springpractice.domain.entities.base.EntityBase;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository("GenericRepository")
public interface IGenericRepository<T extends EntityBase, U> {
    T save(T entity);

    List<T> getAll();

    T getById(U id);

    List<T> getBy(Example<T> predicate);

    List<T> getBy(Sort sort);
    List<T> getBy(Example<T> predicate, Sort sort);

    <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    void update(T entity, U id);

    void update(T entity);

    void delete(T entity);

    void deleteRange(List<T> entities);

    List<T> getAllById(List<U> ids);
}
