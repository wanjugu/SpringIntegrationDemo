package com.eip.controller;


import com.eip.model.PartyReservation;
import com.eip.service.SwagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class AppController {
    @Autowired
    private SwagService swagService;


    @PostMapping(value = "makeReservation")
    public void makeReservationContentEnricherExample(){
        PartyReservation partyReservation = new PartyReservation(1, "Deluxe", "Santos" );

        swagService.sendSwag(partyReservation);
    }
}
