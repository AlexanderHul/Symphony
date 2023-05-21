package com.example.symphony.repository;

import java.util.List;

public interface BasicRepository<T, ID> {
    T findById(ID id);
    List<T> findAll();
    void save(T entity);
    void delete(T entity);
    void deleteById(ID id);
}
