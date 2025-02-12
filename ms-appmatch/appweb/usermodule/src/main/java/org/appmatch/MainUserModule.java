package org.appmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class MainUserModule {
    public static void main(String[] args) {
        SpringApplication.run(MainUserModule.class, args);
    }
}