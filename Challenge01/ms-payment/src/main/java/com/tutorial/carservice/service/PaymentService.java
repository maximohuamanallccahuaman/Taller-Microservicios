package com.tutorial.carservice.service;

import com.tutorial.carservice.entity.Payment;
import com.tutorial.carservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment save(Payment payment) {
        Payment paymentNew = paymentRepository.save(payment);
        return paymentNew;
    }

    public List<Payment> byOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
