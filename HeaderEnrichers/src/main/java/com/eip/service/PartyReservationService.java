package com.eip.service;

import com.eip.Model.PartyReservation;
import org.springframework.messaging.Message;

public interface PartyReservationService {
    void handlePartyReservation(Message<PartyReservation> partyReservationMessage);

}
