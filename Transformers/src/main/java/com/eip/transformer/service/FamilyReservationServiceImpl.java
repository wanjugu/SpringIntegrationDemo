package com.eip.transformer.service;

import com.eip.transformer.config.FamilyReservationGateway;
import com.eip.transformer.models.FamilyReservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FamilyReservationServiceImpl implements FamilyReservationService{

    @Autowired
    private FamilyReservationGateway gateway;


    @Override
    public void bookFamilyReservation(FamilyReservation familyReservation) {
        log.info("Publishing family reservation {} to family reservation channel",
                familyReservation.getFamilyId());

        gateway.publishFamilyReservation(familyReservation);


    }
}
