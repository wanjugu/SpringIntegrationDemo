package com.eip.service;

import com.eip.Config.AuditChannelGateway;
import com.eip.Model.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PartyReservationServiceImpl implements PartyReservationService{
    @Autowired
    private AuditChannelGateway auditChannelGateway;


    @ServiceActivator(inputChannel = "partyReservationChannel")
    @Override
    public void handlePartyReservation(Message<PartyReservation> partyReservationMessage) {

        log.info("message Headers : {} ", partyReservationMessage.getHeaders());

        String authToken =(String) partyReservationMessage.getHeaders().get("AUTH_TOKEN");
        if(authToken.equals("12345")){
            PartyReservation partyReservation = partyReservationMessage.getPayload();

            log.info("Book party reservation for {}: {}", partyReservation.getPartyId(), partyReservation.getName());

            auditChannelGateway.publishPartyReservation(partyReservationMessage);

        }else{
            log.error("Invalid Auth Token");
        }


    }
}
