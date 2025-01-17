package com.eip.transformer.config;

import com.eip.transformer.models.FamilyReservation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "familyReservationGateway", defaultRequestChannel = "familyReservationChannel")
public interface FamilyReservationGateway {
    @Gateway
    void publishFamilyReservation(FamilyReservation familyReservation);
}
