package com.eip.service;

import com.eip.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PartyRetrivalServiceImpl implements PartyRetrivalService{

    @ServiceActivator(inputChannel = "partyReservationEnricherChannel")
    @Override
    public Address getPartyAddress(String partyId) {
        log.info("PartyRetrievalService - Retrieve address for partyId: {{}",partyId);
        return new Address("123 Moi Avenue","Nairobi,City", "St","12344");
    }
}
