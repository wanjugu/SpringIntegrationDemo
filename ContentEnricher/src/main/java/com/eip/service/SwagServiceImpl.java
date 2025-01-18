package com.eip.service;

import com.eip.Config.SwagChannelGateway;
import com.eip.model.PartyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SwagServiceImpl implements  SwagService{

    @Autowired
    private SwagChannelGateway swagChannelGateway;

    @Override
    public void sendSwag(PartyReservation partyReservation) {
        log.info("Publishing message to swag with PartyId: {}:",partyReservation.getPartyId());
        swagChannelGateway.sendSwag(partyReservation);

    }
}
