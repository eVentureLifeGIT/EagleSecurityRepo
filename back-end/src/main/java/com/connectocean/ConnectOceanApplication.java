package com.connectocean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ConnectOceanApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConnectOceanApplication.class, args);
    }
}