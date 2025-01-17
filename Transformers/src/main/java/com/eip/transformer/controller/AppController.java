package com.eip.transformer.controller;


import com.eip.transformer.models.FamilyReservation;
import com.eip.transformer.service.FamilyReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class AppController {

    @Autowired
    FamilyReservationService familyReservationService;


    @PostMapping(value = "makeReservation")
    public ResponseEntity<?> makeFamilyReservation(@RequestBody FamilyReservation reservation){

        FamilyReservation familyReservation = new FamilyReservation(
                reservation.getFamilyId(), reservation.getName(),
                reservation.getRoomType(), reservation.getNumberOfChildren());

        familyReservationService.bookFamilyReservation(familyReservation);


        return new ResponseEntity<>("Reservation Made", HttpStatus.OK);


    }

}
