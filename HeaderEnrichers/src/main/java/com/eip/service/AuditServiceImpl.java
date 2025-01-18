package com.eip.service;

import com.eip.Model.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AuditServiceImpl implements AuditService{

    @ServiceActivator(inputChannel = "auditChannel")
    @Override
    public void handlePArtyReservation(Message<PartyReservation> partyReservationMessage) {
        log.info("AuditService: Message Headers: {}",partyReservationMessage.getHeaders());
    }
}
