package com.eip.service;


import com.eip.model.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SwagFullfilmentServiceImpl implements  SwagFullfilmentService{

    @ServiceActivator(inputChannel = "swagFulfillmentServiceChannel")
    @Override
    public void fulfillswag(PartyReservation partyReservation) {
        log.info("Sending Swag for partyId: {} to {}, {}, {}, {}",
                partyReservation.getPartyId(),
                partyReservation.getAddress(),
                partyReservation.getCity(),
                partyReservation.getState(),
                partyReservation.getZip());

    }
}
