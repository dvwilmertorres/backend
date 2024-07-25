package org.appmatch.services;

import org.springframework.http.ResponseEntity;

public interface OrderDetailService {
    ResponseEntity<String> crudOrder(String request);
    ResponseEntity<String> findAllOrder();
}
