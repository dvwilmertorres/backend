package org.appmatch.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Component
@Slf4j
public class EncoderUtils {
    public static String base64Decode(String encodado) {
        // Decodificar la cadena base64
        byte[] decodedBytes = Base64.decodeBase64(encodado);
        // Convertir los bytes a una cadena UTF-8

        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    public static String base64Encode(String encode) {
        Base64 base64 = new Base64();
        return base64.encodeToString(encode.getBytes());
    }
    public static boolean isBase64Format(String encode) {
        return encode.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");
    }
    public static void validateBase64(String request) {
        if (Objects.nonNull(request) && isBase64Format(request)) {
            //log.info("request: \n{}", EncoderUtils.base64Decode(request));
        } else {
            //log.info("Base 64 no valido");
            throw new IllegalArgumentException("BASE64 NO VALIDO");
        }
    }
    public static <T> T decodeRequest(String encode, Class<T> type){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(base64Decode(encode), type);
        } catch (UnrecognizedPropertyException e) {
            throw new ValidationException(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new ValidationException(e.getMessage());
        }
    }
    public static String encodeResponse(Object response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return base64Encode(objectMapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
