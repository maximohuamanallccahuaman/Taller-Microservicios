package com.tutorial.carservice.controller;

import com.tutorial.carservice.entity.Payment;
import com.tutorial.carservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payments = paymentService.getAll();
        if(payments.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable("id") int id) {
        Payment payment = paymentService.getPaymentById(id);
        if(payment == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(payment);
    }

    @PostMapping()
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        Payment paymentNew = paymentService.save(payment);
        return ResponseEntity.ok(paymentNew);
    }

    @GetMapping("/byorder/{orderId}")
    public ResponseEntity<List<Payment>> getByOrderId(@PathVariable("orderId") int orderId) {
        List<Payment> payments = paymentService.byOrderId(orderId);
        if(payments.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(payments);
    }

}
