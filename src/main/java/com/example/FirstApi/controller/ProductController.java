package com.example.FirstApi.controller;

import com.example.FirstApi.controller.Interface.IBaseController;
import com.example.FirstApi.model.Product;
import com.example.FirstApi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Endpoints de produto")
public class ProductController implements IBaseController<Product> {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Listar todos os produtos")
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return product!=null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo produto")
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto existente")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir produto")
    public String delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}
