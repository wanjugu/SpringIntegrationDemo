package com.eip.controllers;


import com.eip.Model.PartyReservation;
import com.eip.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class appController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "reserve")
    public void partyReservation(){

        PartyReservation partyReservation = new PartyReservation(1,"VIP","Dluxe","2");

        reservationService.bookPartyReservation(partyReservation);


    }

}
