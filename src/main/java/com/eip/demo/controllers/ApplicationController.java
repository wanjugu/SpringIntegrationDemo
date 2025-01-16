package com.eip.demo.controllers;


import com.eip.demo.model.GroupReservation;
import com.eip.demo.model.PartyReservation;
import com.eip.demo.model.PurchaseOrder;
import com.eip.demo.model.SupportTicket;
import com.eip.demo.service.PaymentService;
import com.eip.demo.service.ReservationService;
import com.eip.demo.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    SupportService supportService;

    @Autowired
    PaymentService paymentService;


    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "create")
    public ResponseEntity createTicket(@RequestBody SupportTicket ticket){

        supportService.openTicket(ticket.getCustomer(),
                ticket.getRiskLevel(), ticket.getDescription());

        return new ResponseEntity("Sucess", HttpStatus.OK);

    }

    @PostMapping(value = "processOrder")
    public ResponseEntity processOrder(@RequestBody PurchaseOrder order){

        paymentService.submitPurchaseOrder(order);

        return new ResponseEntity("Order Submitted", HttpStatus.OK);
    }

    /**
     *  Demo for Splitters
     * */
    @PostMapping(value = "bookReservation")
    public ResponseEntity parttyReservation(){


        GroupReservation groupReservation = new GroupReservation();
        groupReservation.setReservationId("123");
        groupReservation.getParties().add(new PartyReservation(1,"Double","Smith"));
        groupReservation.getParties().add(new PartyReservation(2,"Single","JOnes"));

        reservationService.bookGroupReservation(groupReservation);

        return new ResponseEntity("Order Submitted", HttpStatus.OK);
    }
}
