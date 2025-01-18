package com.eip;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeaderEnricher {
    public static void main(String[] args) {
        SpringApplication.run(HeaderEnricher.class,args);
        System.out.println("+++++++++++");
    }
}