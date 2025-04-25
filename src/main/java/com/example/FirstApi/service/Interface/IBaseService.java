package com.example.FirstApi.service.Interface;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T entity);
    String delete(Long id);
    T update(Long id, T entity);
}
