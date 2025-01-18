package com.eip.Config;


import com.eip.Model.PartyReservation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "auditChannelGateway", defaultRequestChannel = "headerEnricherRemoveAuthChannel")
public interface AuditChannelGateway {

    @Gateway
    void publishPartyReservation(Message<PartyReservation> partyReservation);
}
