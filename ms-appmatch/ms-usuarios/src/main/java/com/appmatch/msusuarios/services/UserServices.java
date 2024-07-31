package com.appmatch.msusuarios.services;

import com.appmatch.msusuarios.entity.UserSesionEntity;
import org.springframework.http.ResponseEntity;

public interface UserServices {
    ResponseEntity<String> crudUser(String request);
    ResponseEntity<UserSesionEntity> Login(String request);
}
