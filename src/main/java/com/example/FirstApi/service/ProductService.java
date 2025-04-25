package com.example.FirstApi.service;

import com.example.FirstApi.model.Product;
import com.example.FirstApi.repository.IProductRepository;
import com.example.FirstApi.service.Interface.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IBaseService<Product> {

    private final RestTemplate restTemplate;
    private final String URL_BASE = "https://fakestoreapi.com/products/";


    public List<Product> findAll() {

        Product[] products = restTemplate.getForObject(URL_BASE, Product[].class);

        if (products != null) {
            return Arrays.asList(products);
        }
        return null;
    }

    public Product findById(Long id) {
        String url = URL_BASE + id;
        return restTemplate.getForObject(url, Product.class);
    }

    public Product save(Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> request = new HttpEntity<>(product, headers);
        ResponseEntity<Product> response = restTemplate.postForEntity(URL_BASE, request, Product.class);
        return response.getBody();
    }

    public String delete(Long id) {
        String url = URL_BASE + id;
        try {
            restTemplate.delete(url);
            return "Produto excluído com sucesso!";
        } catch (Exception e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
            return "Erro ao tentar excluir o produto.";
        }
    }

    @Override
    public Product update(Long id, Product entity) {
        Product existProduct = findById(id);
        restTemplate.put(URL_BASE + id, existProduct);
        return existProduct;
    }
}
