package com.ps.PaymentService.service;

import com.ps.PaymentService.model.PaymentRequest;
import com.ps.PaymentService.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
