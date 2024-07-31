package com.appmatch.msproduct.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ErrorControlUtils {
    public final ResponseEntity<String> handleSuccess(Object object) {
       String encodeResponse = EncoderUtils.encodeResponse(object);
        return ResponseEntity.status(HttpStatus.OK).body(encodeResponse);
    }
}
