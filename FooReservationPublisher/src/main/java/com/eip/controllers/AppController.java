package com.eip.controllers;


import com.eip.models.FooReservation;
import com.eip.service.FooReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AppController {

    @Autowired
    public FooReservationService reservationService;

    @PostMapping(value = "fooReservation")
    public void reserveWithRabbitMQDemo(){



        List<FooReservation> reservationList = Arrays.asList(
                new FooReservation(1, "User 1"),
                new FooReservation(2, "User 2"),
                new FooReservation(3, "User 3"),
                new FooReservation(4, "User 4"),
                new FooReservation(5, "User 5"));

        reservationList.forEach(reservation->{
            reservationService.publishReservation(reservation);
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }
}
