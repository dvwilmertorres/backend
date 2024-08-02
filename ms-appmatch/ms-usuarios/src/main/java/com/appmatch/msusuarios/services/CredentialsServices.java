package com.appmatch.msusuarios.services;

import org.springframework.http.ResponseEntity;

public interface CredentialsServices {
    ResponseEntity<String> crudUser(String request);
}
