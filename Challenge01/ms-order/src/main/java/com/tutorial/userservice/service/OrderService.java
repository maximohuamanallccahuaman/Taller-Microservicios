package com.tutorial.userservice.service;

import com.tutorial.userservice.entity.Order;
import com.tutorial.userservice.model.Payment;
import com.tutorial.userservice.model.Product;
import com.tutorial.userservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order save(Order order) {
        Order orderNew = orderRepository.save(order);
        return orderNew;
    }

    public List<Product> getProducts(int orderId) {
        List<Product> products = restTemplate.getForObject("http://localhost:8006/product/byorder/" + orderId, List.class);
        return products;
    }

    public List<Payment> getPayments(int orderId) {
        List<Payment> payments = restTemplate.getForObject("http://localhost:8007/payment/byorder/" + orderId, List.class);
        return payments;
    }
}
