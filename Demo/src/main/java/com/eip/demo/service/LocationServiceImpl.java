package com.eip.demo.service;


import com.eip.demo.config.RecipientListRouterChannelGateway;
import com.eip.demo.model.LocationRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private RecipientListRouterChannelGateway gateway;

    @Override
    public void saveLocation(String gpsLocation, String customerId) {
        log.info("Saving location for Customer {}: {}",customerId, gpsLocation);

        Message<LocationRecord> message = MessageBuilder.withPayload(
                new LocationRecord(customerId,gpsLocation)).build();

        gateway.routeMessage(message);





    }
}
