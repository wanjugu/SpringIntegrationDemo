package com.eip.demo.service;

import com.eip.demo.model.ReservationRecord;
import org.springframework.messaging.Message;

public interface ReservationRecordService {
    Message<String> processReservationRecord(Message<ReservationRecord> reservationRecordMessasge);

}
