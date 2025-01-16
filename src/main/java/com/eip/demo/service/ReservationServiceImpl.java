package com.eip.demo.service;

import com.eip.demo.config.GroupReservationChannelGateway;
import com.eip.demo.config.RouterChannelGateway;
import com.eip.demo.model.GroupReservation;
import com.eip.demo.model.ReservationConfirmation;
import com.eip.demo.model.ReservationRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class ReservationServiceImpl implements ReservationService{
    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @Autowired
    private RouterChannelGateway gateway;

    @Autowired
    private GroupReservationChannelGateway groupReservationChannelGateway;

    @Override
    public void addReservationRecord(String id, String name) {
        Message<String> reservationRecordMessage = gateway.routeMessage(
                MessageBuilder.withPayload(new ReservationRecord(id,name)).build());
        logger.info("Received result from reservation record message {}",
                reservationRecordMessage.getPayload());
    }

    @Override
    public void completeReservation(String reservationId, String confirmationNumber) {
        Message<String> reservationConfirmationMessage = gateway.routeMessage(
                MessageBuilder.withPayload(new ReservationConfirmation(reservationId,confirmationNumber)).build());

        logger.info("Received result from reservation confirmation channel {}",
                reservationConfirmationMessage.getPayload());

    }

    @Override
    public void bookGroupReservation(GroupReservation groupReservation) {
        logger.info("Publishing group reservation {} to the reservation channel",
                groupReservation.getReservationId());

        groupReservationChannelGateway.publishGroupReservation(MessageBuilder.withPayload(groupReservation).build());
    }
}
