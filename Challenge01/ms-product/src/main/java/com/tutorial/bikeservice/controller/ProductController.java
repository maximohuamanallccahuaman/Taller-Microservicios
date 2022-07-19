package com.tutorial.bikeservice.controller;

import com.tutorial.bikeservice.entity.Product;
import com.tutorial.bikeservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@RestController
@RequestMapping("/product")
public class ProductController extends RuntimeException{

    @Autowired
    ProductService productService;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = productService.getAll();
        if(products.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        if(product == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product productNew = productService.save(product);
        return ResponseEntity.ok(productNew);
    }

    @GetMapping("/byproduct/{productId}")
    public ResponseEntity<List<Product>> getByOrderId(@PathVariable("orderId") int orderId) {
        List<Product> products = productService.byOrderId(orderId);
        if(products.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

}
