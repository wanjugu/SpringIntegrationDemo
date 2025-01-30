package com.eip.service;


import com.eip.FooReservationDemo;
import com.eip.config.FooReservationGateway;
import com.eip.models.FooReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FooReservationService {

    @Autowired
    private FooReservationGateway fooReservationGateway;

    public void publishReservation(FooReservation reservation){
        log.info("Publishing reservation {}  for user {}", reservation.getId(),reservation.getName());

        fooReservationGateway.publishReservation(reservation);

    }

}
