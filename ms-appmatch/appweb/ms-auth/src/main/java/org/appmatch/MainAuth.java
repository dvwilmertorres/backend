package org.appmatch;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableEncryptableProperties
public class MainAuth {
    public static void main(String[] args) {
        SpringApplication.run(MainAuth.class, args);
    }
}