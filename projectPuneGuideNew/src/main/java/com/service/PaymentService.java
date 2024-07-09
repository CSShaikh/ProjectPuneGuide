package com.service;

import java.util.List;
import java.util.Map;

import com.model.Payment;
import com.exception.PaymentNotFoundException;

public interface PaymentService {

    Payment createPayment(Payment payment);

    Payment getOnePayment(int id);

    Map<String, Object> deletePayment(int id) throws PaymentNotFoundException;

    Payment updatePayment(Payment payment) throws PaymentNotFoundException;

    List<Payment> getAllPayments();
}
