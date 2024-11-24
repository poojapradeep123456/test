package com.product.test.controller;

import java.util.List;
import java.util.Optional;

import com.product.test.model.Products;
import com.product.test.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Products addProduct(@RequestBody Products product) {
        return productService.addProduct(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable int id, @RequestBody Products product) {
        return productService.updateProduct(id, product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public Void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return null;
    }

    @GetMapping("/revenue")
    public Double getTotalRevenue() {
        return productService.getTotalRevenue();
    }

    @GetMapping("/revenue/{productId}")
    public Double getRevenueByProduct(@PathVariable int productId) {
        return productService.getRevenueByProduct(productId);
    }
}

