package com.eip.demo.service;


import com.eip.demo.model.ReservationRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class ReservationRecordServiceImpl implements ReservationRecordService {
    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @ServiceActivator(inputChannel = "reservationRecordChannel")
    @Override
    public Message<String> processReservationRecord(Message<ReservationRecord> reservationRecordMessasge) {
        ReservationRecord reservationRecord = reservationRecordMessasge.getPayload();
        logger.info("Reservation Record: id={}, name={}",reservationRecord.getId(), reservationRecord.getName() );
        return MessageBuilder.withPayload("SUCCESS").build();

    }
}
