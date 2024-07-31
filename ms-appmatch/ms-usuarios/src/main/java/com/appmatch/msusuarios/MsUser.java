package com.appmatch.msusuarios;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class MsUser {

    private static final Logger logger = LoggerFactory.getLogger(MsUser.class);

    public static void main(String[] args) {
            SpringApplication.run(MsUser.class, args);
            logger.info("MsUser inicia correctamente");

    }

}
