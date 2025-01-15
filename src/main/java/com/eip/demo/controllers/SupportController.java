package com.eip.demo.controllers;


import com.eip.demo.model.SupportTicket;
import com.eip.demo.service.SupportService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SupportController {

    @Autowired
    SupportService supportService;

    @PostMapping(value = "create")
    public ResponseEntity createTicket(@RequestBody SupportTicket ticket){

        supportService.openTicket(ticket.getCustomer(),
                ticket.getRiskLevel(), ticket.getDescription());

        return new ResponseEntity("Sucess", HttpStatus.OK);


    }
}
