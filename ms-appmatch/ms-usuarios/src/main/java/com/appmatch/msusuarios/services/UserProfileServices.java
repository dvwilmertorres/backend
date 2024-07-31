package com.appmatch.msusuarios.services;

import org.springframework.http.ResponseEntity;

public interface UserProfileServices {
    ResponseEntity<String> crudUser(String request);
}
