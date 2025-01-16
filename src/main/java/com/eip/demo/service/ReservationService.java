package com.eip.demo.service;

import com.eip.demo.model.GroupReservation;
import org.springframework.stereotype.Service;

public interface ReservationService {
    void addReservationRecord(String id, String name);
    void completeReservation(String reservationId, String confirmationNumber);

    void bookGroupReservation(GroupReservation groupReservation);
}
