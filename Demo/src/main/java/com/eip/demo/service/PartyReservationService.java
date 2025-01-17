package com.eip.demo.service;

import com.eip.demo.model.PartyReservation;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public interface PartyReservationService {
    void handlePartyReservation(Message<PartyReservation> partyReservationMessage);
}
