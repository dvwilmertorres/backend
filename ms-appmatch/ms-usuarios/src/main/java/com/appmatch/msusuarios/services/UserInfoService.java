package com.appmatch.msusuarios.services;

import org.springframework.http.ResponseEntity;

public interface UserInfoService {
    ResponseEntity<String> crudInfoService(String request);
}
