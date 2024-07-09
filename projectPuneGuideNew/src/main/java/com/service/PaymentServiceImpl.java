package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PaymentRepository;
import com.exception.PaymentNotFoundException;
import com.model.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public Payment getOnePayment(int id) {
        return paymentRepo.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> deletePayment(int id) throws PaymentNotFoundException {
        Map<String, Object> response = new HashMap<>();

        Payment payment = paymentRepo.findById(id).orElseThrow(() -> new PaymentNotFoundException(id + " Payment not exist"));
        paymentRepo.delete(payment);
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    
    public Payment updatePayment(Payment payment) throws PaymentNotFoundException {
        Payment p = paymentRepo.findById(payment.getId()).orElseThrow(() -> new PaymentNotFoundException("Payment Not exist"));
        p.setPaymentDate(payment.getPaymentDate());
        p.setPaymentMethod(payment.getPaymentMethod());
        p.setAmount(payment.getAmount());
        p.setBooking(payment.getBooking());
        p.setStatus(payment.getStatus());
        return paymentRepo.save(p);
    }

    
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }
}
