package com.indoleads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class IndobidsApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndobidsApplication.class, args);
    }

}
