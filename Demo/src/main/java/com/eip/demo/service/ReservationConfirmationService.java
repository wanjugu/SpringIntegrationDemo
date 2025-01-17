package com.eip.demo.service;

import com.eip.demo.model.ReservationConfirmation;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


public interface ReservationConfirmationService {
    Message<String> processString(Message<ReservationConfirmation> reservationConfirmationMessage);
}
