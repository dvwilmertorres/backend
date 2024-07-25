package com.appmatch.msusuarios.services;

import com.appmatch.msusuarios.entity.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserServices {
    ResponseEntity<String> crudUser(String request);
    ResponseEntity<UserEntity> Login(String request);
}
