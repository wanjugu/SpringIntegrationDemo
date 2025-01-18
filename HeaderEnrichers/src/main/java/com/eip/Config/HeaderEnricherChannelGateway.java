package com.eip.Config;


import com.eip.Model.PartyReservation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "HeaderEnricherChannelGateway", defaultRequestChannel = "headerEnricherAddAuthChannel")
public interface HeaderEnricherChannelGateway {

    @Gateway
    void publishPartyReservation(PartyReservation partyReservation);
}
