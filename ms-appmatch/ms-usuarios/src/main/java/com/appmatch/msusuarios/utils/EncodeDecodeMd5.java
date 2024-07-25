package com.appmatch.msusuarios.utils;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class EncodeDecodeMd5 {
    public static String encodeMd5(String input) {
        try {
            // Crear un MessageDigest instance para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calcular el digest de la cadena de entrada
            byte[] messageDigest = md.digest(input.getBytes());

            // Convertir el byte array en un BigInteger
            BigInteger number = new BigInteger(1, messageDigest);

            // Convertir el BigInteger en un string hexadecimal
            StringBuilder hexString = new StringBuilder(number.toString(16));

            // Rellenar con ceros para asegurar que tenga 32 caracteres
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
