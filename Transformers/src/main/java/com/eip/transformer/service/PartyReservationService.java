package com.eip.transformer.service;

import com.eip.transformer.models.PartyReservation;
import org.springframework.http.codec.multipart.Part;
import org.springframework.messaging.Message;

public interface PartyReservationService {

    void handlePartyReservation(Message<PartyReservation> partyReservation);
}
