package com.nuzhd.repository;

import java.util.Collection;

public interface CommonRepository<T>{
    T save(T domain);
    void delete(T domain);
    Iterable<T> saveAll(Collection<T> domains);
    T findById(String id);
    Iterable<T> findAll();
}
