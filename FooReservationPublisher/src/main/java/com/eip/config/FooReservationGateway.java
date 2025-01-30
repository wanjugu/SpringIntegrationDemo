package com.eip.config;


import com.eip.FooReservationDemo;
import com.eip.models.FooReservation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name="fooReservationGateway",defaultRequestChannel = "reservationChannel")
public interface FooReservationGateway {

    @Gateway
    void publishReservation(FooReservation fooReservation);
}
