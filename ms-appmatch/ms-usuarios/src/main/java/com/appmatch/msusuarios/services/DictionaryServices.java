package com.appmatch.msusuarios.services;

import com.appmatch.msusuarios.entity.DictionaryEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface DictionaryServices {
    ResponseEntity<String> crudDictionary(String request);
    ResponseEntity<String> findAll() throws JsonProcessingException;
}
