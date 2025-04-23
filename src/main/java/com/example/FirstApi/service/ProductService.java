package com.example.FirstApi.service;

import com.example.FirstApi.model.Product;
import com.example.FirstApi.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final IProductRepository iProductRepository;
    private final RestTemplate restTemplate;


    public List<Product> findAll() {
        String url = "https://fakestoreapi.com/products/";
        Product[] products = restTemplate.getForObject(url, Product[].class);
        
        if (products !=null){
            return Arrays.asList(products);
        }
        return null;
    }

    public Optional<Product> findById(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        return Optional.ofNullable(restTemplate.getForObject(url, Product.class));
    }

    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }
}
