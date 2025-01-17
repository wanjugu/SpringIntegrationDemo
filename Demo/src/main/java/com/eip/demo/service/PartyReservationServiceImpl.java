package com.eip.demo.service;


import com.eip.demo.config.ReservationAggregatorChannelGateway;
import com.eip.demo.model.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PartyReservationServiceImpl implements PartyReservationService {
    @Autowired
    private ReservationAggregatorChannelGateway gateway;

    @ServiceActivator(inputChannel = "partyReservationChannel")
    @Override
    public void handlePartyReservation(Message<PartyReservation> partyReservationMessage) {
        PartyReservation partyReservation = partyReservationMessage.getPayload();
        log.info("Book Party reservation for {}: {}",
                partyReservation.getPartyId(), partyReservation.getName());

        //Handle a random confirmation number
        partyReservation.setConfirmationNumber(Integer.toString(( int)(Math.random()*1000)));
        gateway.publishPartyReservation(MessageBuilder.withPayload(partyReservation).copyHeaders(
                partyReservationMessage.getHeaders()).build());
    }
}
