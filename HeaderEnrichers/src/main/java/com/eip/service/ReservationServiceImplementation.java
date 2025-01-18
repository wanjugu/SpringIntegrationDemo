package com.eip.service;

import com.eip.Config.HeaderEnricherChannelGateway;
import com.eip.Model.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReservationServiceImplementation  implements  ReservationService{

    @Autowired
    private com.eip.Config.HeaderEnricherChannelGateway headerEnricherChannelGateway;


    @Override
    public void bookPartyReservation(PartyReservation partyReservation) {
        log.info("Publishing party reservation {} to the header enricher channel", partyReservation.getPartyId());

        headerEnricherChannelGateway.publishPartyReservation(partyReservation);
    }
}
