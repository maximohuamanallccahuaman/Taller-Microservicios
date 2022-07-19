package com.tutorial.bikeservice.service;

import com.tutorial.bikeservice.entity.Product;
import com.tutorial.bikeservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product) {
        Product productNew = productRepository.save(product);
        return productNew;
    }

    public List<Product> byOrderId(int orderId) {
        return productRepository.findByOrderId(orderId);
    }
}
