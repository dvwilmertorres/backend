package org.appmatch.services;

import org.appmatch.entity.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<String> crudUser(String request);
    ResponseEntity<UserEntity> Login(String request);
}
