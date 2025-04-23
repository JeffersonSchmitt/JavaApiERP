package com.example.FirstApi.repository;

import com.example.FirstApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
