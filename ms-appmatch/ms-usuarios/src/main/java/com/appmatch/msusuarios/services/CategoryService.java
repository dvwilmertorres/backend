package com.appmatch.msusuarios.services;

import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<String> crudCategory(String request);
}
