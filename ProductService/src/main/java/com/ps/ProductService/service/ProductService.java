package com.ps.ProductService.service;

import com.ps.ProductService.model.ProductRequest;
import com.ps.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
