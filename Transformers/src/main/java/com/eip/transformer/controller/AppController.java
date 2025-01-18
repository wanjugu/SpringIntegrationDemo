package com.eip.transformer.controller;


import com.eip.transformer.models.FamilyReservation;
import com.eip.transformer.service.FamilyReservationService;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
    public ResponseEntity<?> makeFamilyReservation(@RequestBody String reservation){

//        FamilyReservation familyReservation = new FamilyReservation(
//                reservation.getFamilyId(), reservation.getName(),
//                reservation.getRoomType(), reservation.getNumberOfChildren());
//
//        familyReservationService.bookFamilyReservation(familyReservation);

        System.out.println(JsonParser.parseString(reservation).getAsJsonObject());

//        JsonObject reservationRequestObj = JsonParser.parseString(reservation).getAsJsonObject();

        String reservationRequestObj= "{\"familyId\":1,\"name\":\"Johnsons\",\"roomType\":\"VIP\",\"numberOfChildren\":4}";
        familyReservationService.bookFamilyReservationAsJson(String.valueOf(reservationRequestObj));

        return new ResponseEntity<>("Reservation Made", HttpStatus.OK);


    }

}
