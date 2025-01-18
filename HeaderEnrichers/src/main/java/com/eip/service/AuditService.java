package com.eip.service;

import com.eip.Model.PartyReservation;
import org.springframework.messaging.Message;

public interface AuditService {

    void handlePArtyReservation(Message<PartyReservation> partyReservationMessage);
}
