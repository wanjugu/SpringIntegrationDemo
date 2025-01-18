package com.eip.transformer.service;

import com.eip.transformer.models.FamilyReservation;

public interface FamilyReservationService {
    public void bookFamilyReservation(FamilyReservation familyReservation);

    public void bookFamilyReservationAsJson(String familyReservationJson);
}
