package com.eip;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FooReservationConsumerDemo {
    public static void main(String[] args) {
        SpringApplication.run(FooReservationConsumerDemo.class,args);
        System.out.println("++++++++++");
    }
}