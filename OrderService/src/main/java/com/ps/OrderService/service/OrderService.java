package com.ps.OrderService.service;

import com.ps.OrderService.model.OrderRequest;
import com.ps.OrderService.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
