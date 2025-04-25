package com.example.FirstApi.controller.Interface;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseController<T> {
    List<T> getAll();
    ResponseEntity<T> getById(Long id);
    T create(T entity);
    ResponseEntity<T> update(Long id, T entity);
    String delete(Long id);
}
