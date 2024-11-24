package com.product.test.service;


import java.util.List;
import java.util.Optional;

import com.product.test.model.Products;
import com.product.test.repository.ProductRepository;
import com.product.test.repository.Salerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService{

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final Salerepository saleRepository;

    public ProductService() {
        saleRepository = null;
        productRepository = null;
    }

    // public ProductService(ProductRepository productRepository, SaleRepository saleRepository) {
    //     this.productRepository = productRepository;
    //     this.saleRepository = saleRepository;
    // }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(int id, Products productDetails) {
        Products product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
    }
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public double getTotalRevenue() {
        return productRepository.findAll().stream()
                .mapToDouble(prod -> prod.getQuantity() * prod.getPrice())
                .sum();
    }

    public double getRevenueByProduct(int productId) {
        return saleRepository.findPriceByProductId(productId);
    }
}
