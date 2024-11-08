package com.example.busreservation.service;

import com.example.busreservation.entity.Payment;
import com.example.busreservation.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by id
    public Payment getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }

    // Create a new payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Update an existing payment
    public Payment updatePayment(Long id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            payment.setId(id);
            return paymentRepository.save(payment);
        }
        return null;
    }

    // Delete a payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
