package com.appmatch.msusuarios.services;

import org.springframework.http.ResponseEntity;

public interface UserSesionService {
    ResponseEntity<String> crudUserCredential(String request);
}
