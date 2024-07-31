package com.appmatch.msproduct.services;

import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<String> crudProduct(String request);
    ResponseEntity<String> findAllProducts();
    ResponseEntity<String> findAll();
}
