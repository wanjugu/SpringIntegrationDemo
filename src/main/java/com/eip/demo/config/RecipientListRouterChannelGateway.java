package com.eip.demo.config;


import com.eip.demo.model.LocationRecord;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "recepientListRouterChannelGateway", defaultRequestChannel = "recipientListRouterChannel")
public interface RecipientListRouterChannelGateway {

    @Gateway
    void routeMessage(Message<LocationRecord> message);
}
