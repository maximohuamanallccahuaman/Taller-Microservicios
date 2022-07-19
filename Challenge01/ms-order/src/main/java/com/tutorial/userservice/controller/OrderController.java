package com.tutorial.userservice.controller;

import com.tutorial.userservice.entity.Order;
import com.tutorial.userservice.model.Payment;
import com.tutorial.userservice.model.Product;
import com.tutorial.userservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = orderService.getAll();
        if(orders.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id);
        if(order == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order);
    }

    @PostMapping()
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Order orderNew = orderService.save(order);
        return ResponseEntity.ok(orderNew);
    }

    @GetMapping("/products/{orderId}")
    public ResponseEntity<List<Product>> getProducts(@PathVariable("orderId") int orderId) {
        Order order = orderService.getOrderById(orderId);
        if(order == null)
            return ResponseEntity.notFound().build();
        List<Product> products = orderService.getProducts(orderId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/payments/{orderId}")
    public ResponseEntity<List<Payment>> getPayments(@PathVariable("orderId") int orderId) {
        Order order = orderService.getOrderById(orderId);
        if(order == null)
            return ResponseEntity.notFound().build();
        List<Payment> payments = orderService.getPayments(orderId);
        return ResponseEntity.ok(payments);
    }

}
